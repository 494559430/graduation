package com.qdu.service;

import com.qdu.bean.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface SupplierService {
	
	int doAdd(Supplier supplier);
	Supplier getSupplier(int supplierId);
	Map<String, Object> query(Integer page, Integer rows, Supplier supplier);
	int update(Supplier supplier);

    List<Supplier> getList();
}
