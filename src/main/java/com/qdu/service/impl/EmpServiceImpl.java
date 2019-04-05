package com.qdu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.mapper.EmpMapper;
import com.qdu.mapper.JobMapper;
import com.qdu.service.EmpService;
import org.springframework.stereotype.Service;



@Service
public class EmpServiceImpl implements EmpService {

	@Resource
	EmpMapper mapper1;
	@Resource
	JobMapper mapper2;


	@Override
	public void doAdd(Emp emp) {

	}

	@Override
	public Emp getEmp(int empid) {
		return null;
	}

	@Override
	public Map<String, Object> query(Integer page, Integer rows, Emp emp) {
		return null;
	}

	@Override
	public void update(Emp emp) {

	}

	@Override
	public void addJob(Job job) {
		mapper2.insert(job);
	}
}
