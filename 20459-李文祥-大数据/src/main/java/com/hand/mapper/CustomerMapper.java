package com.hand.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by WenxiangLi on 2018/8/23.
 */
@Repository
public interface CustomerMapper {

    Map<String,Object> login(Map<String, Object> map);

    List<Map<String,Object>> selectAll();

    List<Map<String,Object>> showAddress();

    void update(Map map);

    void deleteRental(Integer customerId);

    void deletePayment(Integer customerId);

    void deleteCustomer(Integer customerId);

    List<Map<String,Object>> showStore();

    void addCustomer(Map map);

    Map<String,Object> select(Integer customerId);
}
