package com.job.res;

import com.job.dto.JobDTO;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("msg")
//@Singleton
public class MyMessage {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {

        return "Got it\n";
    }

    @Path("job")
    public Class<JobResource> getJobList() {
       return JobResource.class;
    }
}
