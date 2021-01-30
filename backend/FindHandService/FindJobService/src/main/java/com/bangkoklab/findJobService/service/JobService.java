package com.bangkoklab.findJobService.service;

import java.util.List;

import com.bangkoklab.findJobService.data.dto.Category;
import com.bangkoklab.findJobService.data.dto.Credit;
import com.bangkoklab.findJobService.data.dto.Job;

public interface JobService {
	void insertJob(Job job) throws Exception;
	void deleteJob(Job job) throws Exception;
	void updateJob(Job job) throws Exception;
	void deletOverDayJob() throws Exception;
	List<Job> findJobs() throws Exception;
	List<Job> findByCategoryJobs(Category category) throws Exception;
	List<Job> findByDong(String dong) throws Exception;
	List<Job> downCredit() throws Exception;
	List<Job> upCredit() throws Exception;
	List<Job> findByCreditJobs(Credit credit) throws Exception;
	List<Job> findByTimeJob(int day) throws Exception;
}
