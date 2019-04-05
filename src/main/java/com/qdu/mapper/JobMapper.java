package com.qdu.mapper;

import com.qdu.bean.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobMapper {
    int deleteByPrimaryKey(Integer jobid);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jobid);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}