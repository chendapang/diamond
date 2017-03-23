package com.ujia.dao;

import java.util.List;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Msg;
import com.ujia.vo.MsgVo;

public interface MsgMapper  extends SqlMapper {
    int deleteByPrimaryKey(String id);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKeyWithBLOBs(Msg record);

    int updateByPrimaryKey(Msg record);
    
    public List<MsgVo> getMsgListByOpenId(String openId);
}