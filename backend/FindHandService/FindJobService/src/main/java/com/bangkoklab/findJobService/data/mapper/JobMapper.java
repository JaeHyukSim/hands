package com.bangkoklab.findJobService.data.mapper;

import com.bangkoklab.findJobService.data.dto.Job;

public interface JobMapper {
	void insertJob(Job job) throws Exception;
	void deleteJob(Job job) throws Exception;
	void updateJob(Job job) throws Exception;
	void deletOverDayJob() throws Exception;
}
