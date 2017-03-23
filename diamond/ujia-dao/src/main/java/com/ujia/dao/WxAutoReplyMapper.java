package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.WxAutoReply;
import com.ujia.vo.WxAutoReplyVo;

public interface WxAutoReplyMapper extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(WxAutoReply record);

    int insertSelective(WxAutoReply record);

    WxAutoReply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxAutoReply record);

    int updateByPrimaryKey(WxAutoReply record);
    
    List<WxAutoReplyVo> getAutoReplyList(Map<String, Object> param);

	Integer getAutoReplyCount(Map<String, Object> param);

	WxAutoReplyVo getAutoReplyByContent(String user_input);
}