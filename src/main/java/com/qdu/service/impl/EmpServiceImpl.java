package com.qdu.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.mapper.EmpMapper;
import com.qdu.mapper.JobMapper;
import com.qdu.service.EmpService;
import com.qdu.utils.ComboNode;
import org.springframework.stereotype.Service;



@Service
public class EmpServiceImpl implements EmpService {

	@Resource
	EmpMapper mapper1;
	@Resource
	JobMapper mapper2;


	@Override
	public void doAdd(Emp emp) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		emp.setHiredate(sdf.format(date));
		emp.setState(2);//默认为普通店员
		mapper1.insert(emp);
	}

	@Override
	public Emp getEmp(int empid) {
		return mapper1.selectByPrimaryKey(empid);
	}

	@Override
	public Map<String, Object> query(Integer page, Integer rows, Emp emp) {
		PageHelper.startPage(page,rows);
		List<Emp> list = mapper1.select(emp);
		PageInfo<Emp> pi = new PageInfo<>(list);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", list);
		result.put("total", pi.getTotal());
		return result;
	}

	@Override
	public void update(Emp emp) {
		mapper1.updateByPrimaryKey(emp);
	}

	@Override
	public void addJob(Job job) {
		mapper2.insert(job);
	}

	@Override
	public List<ComboNode> getJob(int shopid) {
		List<Job> jobList =mapper2.selectByShopid(shopid);
		List<ComboNode> list= new ArrayList<>();
		for (Job job :jobList) {
			list.add(new ComboNode(job.getJobid()+"",job.getJobname()));
		}
		return list;
	}
}
