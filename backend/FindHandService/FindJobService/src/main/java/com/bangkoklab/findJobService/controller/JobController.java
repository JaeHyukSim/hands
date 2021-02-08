package com.bangkoklab.findJobService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.findJobService.data.dto.Credit;
import com.bangkoklab.findJobService.data.dto.Job;
import com.bangkoklab.findJobService.service.JobService;

@RestController
@RequestMapping("/Jobs")
public class JobController {

	@Autowired
	JobService service;

//	입력후 리스트 출력
//	@PostMapping("/insertHand")
//	public ResponseEntity<List<Hand>> insertHand(@RequestBody Hand hand) throws Exception{
//		service.insertHand(hand);
//		return new ResponseEntity<List<Hand>>(service.findHands(),HttpStatus.OK);
//	}

	// 일거리 게시
	// 기본키 중복 예외
	@PostMapping("/insertJob")
	public ResponseEntity<Map<String, Object>> insertJob(@RequestBody Job job) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			job.setJobId(UUID.randomUUID().toString());
			service.insertJob(job);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/jobInfo")
	public ResponseEntity<Job> jobInfo(@RequestParam String jobId) throws Exception{
		return new ResponseEntity<Job>(service.findJobsById(jobId), HttpStatus.OK);
	}

	// 일거리 조회
	@GetMapping("/findJobs")
	public ResponseEntity<List<Job>> findJobs() throws Exception {
		return new ResponseEntity<List<Job>>(service.findJobs(), HttpStatus.OK);
	}

	// 카테고리 별 일거리 조회
	@GetMapping("/findJobsByCategory")
	public ResponseEntity<List<Job>> findByCategory(@RequestParam String category) throws Exception {
		try {
			service.findByCategoryJobs(category);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Job>>(service.findByCategoryJobs(category), HttpStatus.OK);
	}

	// 동별 일거리 조회
	@GetMapping("/findJobsByDong")
	public ResponseEntity<List<Job>> findByDong(@RequestParam String dong) throws Exception {
		try {
			service.findByDong(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Job>>(service.findByDong(dong), HttpStatus.OK);
	}

	// 크레딧 기준 정렬
	@GetMapping("/SortByCredit")
	public ResponseEntity<List<Job>> downCredit(@RequestParam String order) throws Exception {
		List<Job> list = new ArrayList<Job>();
		if (order.equals("Down")) {
			list = service.downCredit();
		} else if (order.equals("Up")) {
			list = service.upCredit();
		}
		return new ResponseEntity<List<Job>>(list, HttpStatus.OK);
	}

	// 크레딧 기준 정렬
	// 수정 필요
	@GetMapping("/findJobsByCredit")
	public ResponseEntity<List<Job>> findJobsByCredit(@RequestBody Credit credit) throws Exception {
	
		System.out.println(credit.getMaxCredit());
		List<Job> list = new ArrayList<Job>();
		List<Job> temp = service.findJobs();
		int min = Integer.parseInt(credit.getMinCredit());
		int max = Integer.parseInt(credit.getMaxCredit());
		for(Job s : temp) {
			int cur = Integer.parseInt(s.getJobCredit());
			if(cur >= min && cur < max) {
				list.add(s);
			}
		}
		
//		try {
//			List<Hand> h = service.findByCreditHands(credit);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return new ResponseEntity<List<Job>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/findByTimeJob")
	public ResponseEntity<List<Job>> findByTimeJob(int day) throws Exception{
		return new ResponseEntity<List<Job>>(service.findByTimeJob(day), HttpStatus.OK);
	}

	// 일거리 삭제
	@DeleteMapping("/deleteJob")
	public ResponseEntity<Map<String, Object>> deleteJob(@RequestBody Job job) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			service.deleteJob(job);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 날짜 지난 일거리 삭제
	@DeleteMapping("/deletOverDayJob")
	public ResponseEntity<Map<String, Object>> deletOverDayeJob() throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			service.deletOverDayJob();
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	// 일거리 수정
	@PutMapping("/updateJob")
	public ResponseEntity<Map<String, Object>> UpdateJob(@RequestBody Job job) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(job.getJobId());
		try {
			service.updateJob(job);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

}
