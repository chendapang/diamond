package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Order;
import com.ujia.vo.OrderVo;

public interface OrderMapper extends SqlMapper  {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    OrderVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKeyWithBLOBs(Order record);

    int updateByPrimaryKey(Order record);
    
    int orderAccount();
    
    public List<OrderVo> getOrders(Map<String, Object> paramMap);
}