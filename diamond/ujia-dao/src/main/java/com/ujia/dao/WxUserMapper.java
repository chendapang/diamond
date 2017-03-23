package com.ujia.dao;

import java.util.List;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.WxUser;

public interface WxUserMapper extends SqlMapper {
    int deleteByPrimaryKey(String id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

	WxUser selectByOpenId(String openid);

	Integer selectTotalCount();

	List<WxUser> userList(Integer startIndex, Integer pageSize);
}