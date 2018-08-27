package com.hand.service.serviceImpl;

import com.hand.mapper.CustomerMapper;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by WenxiangLi on 2018/8/23.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Map<String, Object> login(Map<String, Object> map) {
        return customerMapper.login(map);
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        return customerMapper.selectAll();
    }

    @Override
    public List<Map<String,Object>> showAddress() {
        return customerMapper.showAddress();
    }

    @Override
    public void update(Map map) {
        customerMapper.update(map);
    }

    @Override
    public void delete(Integer customerId) {
        customerMapper.deleteRental(customerId);
        customerMapper.deletePayment(customerId);
        customerMapper.deleteCustomer(customerId);
    }

    @Override
    public List<Map<String, Object>> showStore() {
        return customerMapper.showStore();
    }

    @Override
    public void addCustomer(Map map) {
        customerMapper.addCustomer(map);
    }

    @Override
    public Map<String, Object> select(Integer customerId) {
        return customerMapper.select(customerId);
    }
}
