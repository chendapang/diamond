package com.ujia.virgo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujia.dao.WxScanMapper;
import com.ujia.dao.WxUserMapper;
import com.ujia.model.WxScan;
import com.ujia.model.WxUser;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.virgo.service.UserServiceI;


@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private WxUserMapper wxUserMapper;
	@Autowired
	private WxScanMapper wxScanMapper;

	@Override
	@Transactional
	public void editUserInfo(WxUser wxUserPO) {
		WxUser _user = wxUserMapper.selectByOpenId(wxUserPO.getOpenid());
		if (_user == null) {
			wxUserPO.setId(SeqFactory.createId());
			wxUserMapper.insert(wxUserPO);
		} else {
			wxUserPO.setId(_user.getId());
			wxUserMapper.updateByPrimaryKeySelective(wxUserPO);
		}
	}

	@Override
	@Transactional
	public void unsubscribe(String openid) {
		WxUser wxUserPO = wxUserMapper.selectByOpenId(openid);
		wxUserPO.setSubscribe(false);
		wxUserPO.setUnsubscribeTime(new Date());
		wxUserMapper.updateByPrimaryKeySelective(wxUserPO);

	}



	@Override
	public WxUser getByOpenId(String openid) {

		return wxUserMapper.selectByOpenId(openid);
	}



	@Override
	public PageInfo<WxUser> userList(Integer pageSize, Integer pageNum) {
		Integer total = wxUserMapper.selectTotalCount();
		PageInfo<WxUser> pageInfo = new PageInfo<WxUser>(total, pageNum, pageSize);

		List<WxUser> list = wxUserMapper.userList(pageInfo.getStartIndex(), pageInfo.getPageSize());

		pageInfo.setItems(list);

		return pageInfo;
	}

	@Override
	public void editScan(String openId, String scanId) {
		
		WxScan wxScan = new WxScan();
		
		wxScan.setId(SeqFactory.createId());
		wxScan.setOpenid(openId);
		wxScan.setScanTime(new Date());
		wxScan.setScanId(scanId);
		
		wxScanMapper.insert(wxScan );
	}


}
