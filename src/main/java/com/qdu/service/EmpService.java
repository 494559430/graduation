package com.qdu.service;

import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.utils.ComboNode;

import java.util.List;
import java.util.Map;



public interface EmpService {
	
	int doAdd(Emp emp);
	Emp getEmp(int empid);
	Map<String, Object> query(Integer page, Integer rows, Emp emp);
	int update(Emp emp);
	int addJob(Job job);
	List<ComboNode> getJob(Integer shopid);

	int fire(Integer empid);
}
