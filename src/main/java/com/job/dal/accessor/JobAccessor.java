package com.job.dal.accessor;

import com.job.dal.mapper.JobDetailMapper;
import com.job.dal.mapper.JobMapper;
import com.job.dal.po.Job;
import com.job.dal.po.Job2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class JobAccessor {
    private SqlSessionFactory sqlSessionFactory = null;

    public JobAccessor(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Job> getJobList() {
        List<Job> jobList = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            JobMapper mapper = session.getMapper(JobMapper.class);
            jobList = mapper.getJobList();
        } finally {
            session.close();
        }
        return jobList;
    }

    public Job getJobById(Integer Id) {
        Job job = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            JobDetailMapper mapper = session.getMapper(JobDetailMapper.class);
            job = mapper.getJobById(Id);
        } finally {
            session.close();
        }
        return job;
    }

    public void insertJob(Job2 job) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            JobMapper mapper = session.getMapper(JobMapper.class);
            mapper.insertJob(job);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }

}
