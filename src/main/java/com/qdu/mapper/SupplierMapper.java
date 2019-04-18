package com.qdu.mapper;

import com.qdu.bean.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer supplierid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> select(Supplier supplier);
}