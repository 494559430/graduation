package com.qdu.service;

import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.utils.ComboNode;

import java.util.List;
import java.util.Map;



public interface EmpService {
	
	void doAdd(Emp emp);
	Emp getEmp(int empid);
	Map<String, Object> query(Integer page, Integer rows, Emp emp);
	void update(Emp emp);
	void addJob(Job job);
	List<ComboNode> getJob(int shopid);

}
