package com.ujia.virgo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.WxAutoReplyMapper;
import com.ujia.utils.WxUtils;
import com.ujia.utils.wx.Article;
import com.ujia.utils.wx.BaseMessage;
import com.ujia.utils.wx.Image;
import com.ujia.utils.wx.ImageMessage;
import com.ujia.utils.wx.NewsMessage;
import com.ujia.utils.wx.TextMessage;
import com.ujia.virgo.service.WxAutoReplyServiceI;
import com.ujia.vo.WxAutoReplyVo;

@Service
public class WxAutoReplyServiceImpl implements WxAutoReplyServiceI {

	@Autowired
	private WxAutoReplyMapper wxAutoReplyMapper;

	@Override
	public BaseMessage createMessageByUserInput(String user_input) {

		WxAutoReplyVo war = wxAutoReplyMapper.getAutoReplyByContent(user_input);

		BaseMessage bm = null;
		switch (war.getMsgTypeEnum()) {
		case image:
			ImageMessage im = new ImageMessage();
			Image image = new Image();
			image.setMediaId(war.getSysReply());
			im.setImage(image);

			bm = im;
			
			break;
		case news:
			NewsMessage nm  = new NewsMessage();
			List<Article> articles;
			
			articles = WxUtils.getArticlesByMediaId(war.getSysReply());
			
			nm.setArticles(articles);
			bm = nm;
			break;
		case text:
			TextMessage tm = new TextMessage();
			
			tm.setContent(war.getSysReply());
			bm = tm;
			break;
		default:
			break;

		}

		return bm;
	}
}