package com.qdu.mapper;

import com.qdu.bean.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMapper {
    int deleteByPrimaryKey(Integer empid);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}