package com.fisher.motanservice;

import org.springframework.stereotype.Service;

import com.fisher.api.YarService;
@Service("yarService")
public class YarServiceImpl implements YarService {

	@Override
	public void hello() {
		System.out.println("99999999999999999YAR");
	}

}
