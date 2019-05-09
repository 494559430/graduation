package com.qdu.mapper;

import com.qdu.bean.Salebill;
import com.qdu.bean.SalebillShow;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface SalebillMapper {
    int deleteByPrimaryKey(Integer saleid);

    int insert(Salebill record);

    int insertSelective(Salebill record);

    Salebill selectByPrimaryKey(Integer saleid);

    int updateByPrimaryKeySelective(Salebill record);

    int updateByPrimaryKey(Salebill record);

    List<SalebillShow> getbillBytype(Integer shopid);

    List<SalebillShow> getbillByDate(Map<String,Object> map);
}