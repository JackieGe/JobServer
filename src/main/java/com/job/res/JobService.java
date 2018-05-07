package com.job.res;

import com.job.dal.accessor.JobAccessor;
import com.job.dal.MyBatisConnectionFactory;
import com.job.dal.po.Job;
import com.job.dal.po.Job2;
import com.job.dto.JobDTO;
import com.job.dto.JobDetailDTO;
import com.job.dto.JobDetailDTO2;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("/job")
public class JobService {
    @GET
    @Path("/list")
    public List<JobDTO> getJobList() {
        JobAccessor jobAccessor = new JobAccessor(MyBatisConnectionFactory.getSqlSessionFactory());
        List<Job> jobList = jobAccessor.getJobList();
        List<JobDTO> jobDTOList = jobList.stream()
                .map(job -> new JobDTO(job.getId(), job.getName(), job.getStatus()))
                .collect(Collectors.toList());
        return jobDTOList;
    }

    @GET
    @Path("/list/{Id}")
    public JobDetailDTO getJobDetailById(@PathParam("Id") Integer Id) {
        JobAccessor jobAccessor = new JobAccessor(MyBatisConnectionFactory.getSqlSessionFactory());
        Job job = jobAccessor.getJobById(Id);
        JobDetailDTO jobDetailDTO = new JobDetailDTO(job.getId(), job.getName(), job.getDescription(), job.getStatus());
        return jobDetailDTO;
    }

    @POST
    @Path("/create")
    public void insertJob(JobDetailDTO2 jobDetailDTO) {
        JobAccessor jobAccessor = new JobAccessor(MyBatisConnectionFactory.getSqlSessionFactory());
        Job2 jobPO = new Job2(jobDetailDTO.getId(), jobDetailDTO.getName(), jobDetailDTO.getDescription(), jobDetailDTO.getStatus());
        jobAccessor.insertJob(jobPO);
    }
}
