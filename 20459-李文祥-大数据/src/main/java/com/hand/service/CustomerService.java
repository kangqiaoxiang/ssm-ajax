package com.hand.service;

import java.util.List;
import java.util.Map;

/**
 * Created by WenxiangLi on 2018/8/23.
 */
public interface CustomerService {
    Map<String,Object> login(Map<String, Object> map);

    List<Map<String,Object>> selectAll();

    List<Map<String,Object>> showAddress();

    void update(Map map);

    void delete(Integer customerId);

    List<Map<String,Object>> showStore();

    void addCustomer(Map map);

    Map<String,Object> select(Integer customerId);
}
