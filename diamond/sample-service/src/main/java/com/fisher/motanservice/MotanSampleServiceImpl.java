package com.fisher.motanservice;

import org.springframework.stereotype.Service;

import com.fisher.api.MotanSampleService;
@Service("motanSampleService")
public class MotanSampleServiceImpl implements MotanSampleService {

	@Override
	public void motanTest() {
		System.out.println("motan test success");
		
	}

}
