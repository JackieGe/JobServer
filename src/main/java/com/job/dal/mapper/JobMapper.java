package com.job.dal.mapper;

import com.job.dal.po.Job;
import com.job.dal.po.Job2;

import java.util.List;

public interface JobMapper {
    List<Job> getJobList();

    void insertJob(Job2 job);
}
