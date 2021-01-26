package com.bangkoklab.findHandService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.findHandService.data.dto.Hand;
import com.bangkoklab.findHandService.service.HandService;

@RestController
@RequestMapping("/hands")
public class HandController {
	
	@Autowired
	HandService service;
	
	@GetMapping("/findHands")
	public ResponseEntity<List<Hand>> HandDeals() throws Exception{
		
		return new ResponseEntity<List<Hand>>(service.findHands(),HttpStatus.OK);
	}
}
