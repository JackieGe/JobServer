package com.job.res;

import com.job.dto.JobDTO;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

@Singleton
public class JobResource {
    private final SortedMap<Integer, JobDTO> jobMap = new TreeMap<>();

    {
        jobMap.put(1, new JobDTO(1, "准备", "准备开始"));
        jobMap.put(2, new JobDTO(2, "design", "high level design"));
        System.out.println("jobMap init");
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobList() {
        GenericEntity<Collection<JobDTO>> genericEntity = new GenericEntity<Collection<JobDTO>>(jobMap.values()) {
        };
        return Response.status(200).entity(genericEntity).build();
    }

    @Path("/{id:\\d+}")
    @GET
    public Response getJobById(@PathParam("id") int jobId) {
        if (jobMap.containsKey(jobId)) {
            return Response.ok().header("Content-Type", MediaType.APPLICATION_JSON).entity(jobMap.get(jobId)).build();
        }
        return Response.status(404).entity("not found").build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJob(JobDTO jobDTO) {
        if (jobDTO != null) {
            System.out.println(jobDTO.getName());

            jobDTO.setId(jobMap.lastKey() + 1);
            jobMap.put(jobDTO.getId(), jobDTO);
        }
        return Response.ok().entity(jobDTO).build();
    }
}
