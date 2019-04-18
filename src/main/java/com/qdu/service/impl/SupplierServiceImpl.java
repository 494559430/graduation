package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Supplier;
import com.qdu.mapper.SupplierMapper;
import com.qdu.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierMapper mapper;

    @Override
    public int doAdd(Supplier supplier) {
        return mapper.insert(supplier);
    }

    @Override
    public Supplier getSupplier(int supplierId) {
        return mapper.selectByPrimaryKey(supplierId);
    }

    @Override
    public Map<String, Object> query(Integer page, Integer rows, Supplier supplier) {
        PageHelper.startPage(page,rows);
        List<Supplier> list = mapper.select(supplier);
        PageInfo<Supplier> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return result;
    }

    @Override
    public int update(Supplier supplier) {
        return mapper.updateByPrimaryKey(supplier);
    }
}
