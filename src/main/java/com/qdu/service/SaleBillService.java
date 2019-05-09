package com.qdu.service;

import com.qdu.bean.SalebillShow;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/7.
 */
public interface SaleBillService {
    List<SalebillShow> getSaleBillByType(int id);

    List<SalebillShow> getSaleBillByDate(Map<String, Object> map);
}
