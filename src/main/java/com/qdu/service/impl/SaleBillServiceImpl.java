package com.qdu.service.impl;

import com.qdu.bean.SalebillShow;
import com.qdu.mapper.SalebillMapper;
import com.qdu.service.SaleBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/7.
 */
@Service
public class SaleBillServiceImpl implements SaleBillService {
    @Autowired
    SalebillMapper salebillMapper;

    @Override
    public List<SalebillShow> getSaleBillByType(int id) {
        return salebillMapper.getbillBytype(id);
    }

    @Override
    public List<SalebillShow> getSaleBillByDate(Map<String, Object> map) {
        return salebillMapper.getbillByDate(map);
    }
}
