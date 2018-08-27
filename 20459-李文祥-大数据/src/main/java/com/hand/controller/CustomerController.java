package com.hand.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.service.CustomerService;
import com.hand.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by WenxiangLi on 2018/8/23.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 用户登录
     * @param map
     * @return
     */
    @RequestMapping(value="/login.do" )
    @ResponseBody
    public Map<String,Object> login(@RequestParam Map<String,Object> map, HttpServletRequest request){
        System.out.println(map.get("firstName"));
        Map<String,Object> map2 = customerService.login(map);
        Map<String,Object> map3 = new HashMap<>();
        boolean flag = false;
        if(map2 != null ){
            HttpSession session = request.getSession();
            session.setAttribute("user",map2);
            flag = true;
            map3.put("flag",flag);
        }else{
            map3.put("flag",flag);
        }
        return map3;
    }

    @RequestMapping(value="/showCustomer.do")
    @ResponseBody
    public PageInfo showCustomer(@RequestParam(value="pn",defaultValue="1")Integer pn){
        PageHelper.startPage(pn, 6);
        List<Map<String,Object>> mapList = customerService.selectAll();
        PageInfo page = new PageInfo(mapList,4);
        return page;
    }

    @RequestMapping(value="/showAddress.do")
    @ResponseBody
    public List<Map<String,Object>> showAddress(){
        List<Map<String,Object>> mapList = customerService.showAddress();
        return mapList;
    }

    @RequestMapping(value = "/updateCustomer.do")
    @ResponseBody
    public Map<String,Object> update(@RequestParam Map map){
            Integer addressId = Integer.parseInt(map.get("addressId").toString());
            Integer customerId = Integer.parseInt(map.get("customerId").toString());
            Date date = new Date();
            String lastUpdate = DateUtils.getNowDate(date);
            map.put("lastUpdate",lastUpdate);
            map.put("addressId",addressId);
            map.put("customerId",customerId);
            System.out.println(addressId);
            customerService.update(map);
            boolean flag = true;
            Map map2 = new HashMap();
            map2.put("flag",flag);
            return map2;
    }

    @RequestMapping(value="deleteCustomer.do")
    @ResponseBody
    public Map<String,Object> delete(Integer customerId){
        boolean flag = false;
        customerService.delete(customerId);
        Map map = new HashMap();
        flag = true;
        map.put("flag",flag);
        return map;

    }

    @RequestMapping(value="showStore.do")
    @ResponseBody
    public List<Map<String,Object>> showStore(){
        List<Map<String,Object>> mapList =  customerService.showStore();
        return mapList;
    }

    @RequestMapping(value="addCustomer.do")
    @ResponseBody
    public Map<String,Object> addCustomer(@RequestParam Map map){
        System.out.println(map.get("firstName"));
        Date date = new Date();
        String createDate = DateUtils.getNowDate(date);
        String lastUpdate = DateUtils.getNowDate(date);
        map.put("createDate",createDate);
        map.put("lastUpdate",lastUpdate);
        Integer addressId = Integer.parseInt(map.get("addressId").toString());
        Integer storeId = Integer.parseInt(map.get("storeId").toString());
        map.put("addressId",addressId);
        map.put("storeId",storeId);
        customerService.addCustomer(map);
        Map map2 = new HashMap();
        map2.put("flag",true);
        return map2;
    }

    @RequestMapping(value="signOut.do")
    @ResponseBody
    public Map signOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        Map<String,Object> map = new HashMap<>();
        map.put("flag",true);
        return map;
    }

    @RequestMapping(value="selectById.do")
    @ResponseBody
    public Map<String,Object> select(Integer customerId){
        Map<String,Object> map = customerService.select(customerId);
        return map;
    }
}
