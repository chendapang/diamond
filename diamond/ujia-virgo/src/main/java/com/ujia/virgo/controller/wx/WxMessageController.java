package com.ujia.virgo.controller.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ujia.model.WxUser;
import com.ujia.utils.WxUtils;
import com.ujia.utils.wx.Article;
import com.ujia.utils.wx.BaseMessage;
import com.ujia.utils.wx.Image;
import com.ujia.utils.wx.ImageMessage;
import com.ujia.utils.wx.MessageUtil;
import com.ujia.utils.wx.NewsMessage;
import com.ujia.utils.wx.TextMessage;
import com.ujia.virgo.service.UserServiceI;
import com.ujia.virgo.service.WxAutoReplyServiceI;

@Controller
@RequestMapping("/wx")
public class WxMessageController {

private static final String TOKEN = "lovemeandlovemyjava";

	@Autowired
	private UserServiceI userService;
	@Autowired
	private WxAutoReplyServiceI wxAutoReplyServiceI;
	
	
	@RequestMapping("getAccessToken")
	@ResponseBody
	public Object getAccessToken() {
		
		String access_token = WxUtils.getAccess_token();
		
		return access_token;
	}

	@RequestMapping("/checkSignature")
	@ResponseBody
	public void checkSignature(String signature, String timestamp, String nonce, String echostr,
			HttpServletRequest request, HttpServletResponse response) {
		String access_token = WxUtils.getAccess_token();

		System.out.println("access_token:" + access_token);

		String[] _c = { TOKEN, timestamp, nonce };
		Arrays.sort(_c);
		String s = _c[0] + _c[1] + _c[2];
		String sha = DigestUtils.shaHex(s.getBytes());
		
		try {
			if (sha.equals(signature)) {

				if (request.getMethod().equalsIgnoreCase("get")) {
					response.getOutputStream().print(echostr);
				} else {
					String rocessRequest = rocessRequest(request, response);

					PrintWriter writer = response.getWriter();
					writer.print(rocessRequest);

					writer.flush();
					writer.close();
				}
			} else {
				response.getOutputStream().print("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	private String rocessRequest(HttpServletRequest request, HttpServletResponse response) {
		String respMessage = "";
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String userOpen_id = (String) requestMap.get("FromUserName");

			String developerId = (String) requestMap.get("ToUserName");
			String msgType = (String) requestMap.get("MsgType");
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(userOpen_id);
			textMessage.setFromUserName(developerId);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setFuncFlag(0);

			BaseMessage baseMessage = new BaseMessage();
			baseMessage.setToUserName(userOpen_id);
			baseMessage.setFromUserName(developerId);
			baseMessage.setCreateTime(new Date().getTime());
			baseMessage.setMsgType("transfer_customer_service");

			respMessage = MessageUtil.messageToXml(baseMessage);
			if (msgType.equals("text")) {

				String Content = requestMap.get("Content").toString();
				System.out.println(Content);
				
				BaseMessage bm = wxAutoReplyServiceI.createMessageByUserInput(Content);
				
				
				respMessage = MessageUtil.messageToXml(bm);
				

			} else if (msgType.equals("image")) {
			} else if (msgType.equals("location")) {
			} else if (msgType.equals("link")) {
			} else if (msgType.equals("voice")) {
			} else if (msgType.equals("event")) {
				String eventType = (String) requestMap.get("Event");
				System.out.println("eventType=======================" + eventType);

				if (eventType.equals("SCAN")) {

					String scanId = (String) requestMap.get("EventKey");

					userService.editScan(userOpen_id, scanId);
				}

				if (eventType.equals("subscribe")) {
					String str = "";
					str += "谢谢宝宝关注我，你一定是热爱生活的人儿！\r\n";
					str += "戳<a href='http://m.u-workshop.com/index.html?source_ref=%E5%BE%AE%E4%BF%A1%E6%95%B4%E8%A3%85%E5%85%B3%E6%B3%A8%E5%9B%9E%E5%A4%8D'>U家工场整装介绍</a>了解成都口碑NO.1の互联网家装；\r\n";
					str += "戳 <a href='http://m.u-workshop.com/activities/315/index.html?source_ref=%E5%BE%AE%E4%BF%A1%E5%BC%95%E5%AF%BC%E8%AF%AD'>3.15活动</a> 享U家最新优惠升级活动\r\n";
					str += "戳<a href='http://h5.u-workshop.com/share/oldPlayer.html'>666现金红包</a>推荐U家给好友，领666现金红包；\r\n";
					str += "戳<a href='http://m.u-workshop.com/wechat_yanfang.html'>免费验房</a>专业验房，U家来帮忙；\r\n";
					str += "或输入问题勾搭小U客服；\r\n";
					str += "小U顾问热线：4006166002\r\n";
					str += "最后，听我默念一遍：\r\n";
					str += "坚守初心，只为品质家装！";
					textMessage.setContent(str);

					respMessage = MessageUtil.messageToXml(textMessage);

					String scanId = (String) requestMap.get("EventKey");

					if (StringUtils.isNotEmpty(scanId)) {
						userService.editScan(userOpen_id, scanId);
					}

					JSONObject wxInfo = WxUtils.getWxInfo(userOpen_id);

					WxUser wxUserPO = wxInfo.parseObject(wxInfo.toJSONString(), WxUser.class);

					wxUserPO.setSubscribeTime(new Date());
					wxUserPO.setScanId(scanId);

					userService.editUserInfo(wxUserPO);

				}
				if (eventType.equals("unsubscribe")) {

					userService.unsubscribe(userOpen_id);
				}
				if (eventType.equals("CLICK")) {
					String EventKey = (String) requestMap.get("EventKey");
					System.out.println("EventKey=======================" + EventKey);
					if (EventKey.equals("zixunkefu")) {
						TextMessage message = new TextMessage();
						message.setContent("欢迎欢迎！我就是小U本人！请输入您想要咨询的问题吧！");
						message.setCreateTime(new Date().getTime());
						message.setFromUserName(developerId);
						message.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(message);

					}
					if (EventKey.equals("ling666hongbao")) {
						NewsMessage nm = new NewsMessage();
						nm.setArticleCount(1);
						List<Article> articles = new ArrayList<>();
						Article a = new Article();
						a.setDescription("666元现金福利来啦！");
						a.setPicUrl(
								"http://mmbiz.qpic.cn/mmbiz_png/GjIBGyWNnkGcMEsPibibYmvmMpXAYXr2GIzusfRweR98VsKuvZADXzcrEOKczqbWlialUSrXCPVJzKFzArEQ2Dlog/0?wx_fmt=png");
						a.setTitle("你推荐，我就送666元现金红包！");
						a.setUrl(
								"http://mp.weixin.qq.com/s?__biz=MzI2OTUxNzQ5OA==&mid=100000011&idx=1&sn=0e3063796df8921079d83f5427a2a924&chksm=6ade56de5da9dfc89f0869b9a02e587e0edd7ad99fdef8672a924c09aa49dfecb379f8594498#rd");
						articles.add(a);
						nm.setArticles(articles);
						nm.setCreateTime(1478084783);
						nm.setFromUserName(developerId);
						nm.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(nm);
					}
					if (EventKey.equals("0yuanzhuangxiu")) {
						NewsMessage nm = new NewsMessage();
						nm.setArticleCount(1);
						List<Article> articles = new ArrayList<>();
						Article a = new Article();
						a.setDescription("手续简单，额度高，放款快。");
						a.setPicUrl(
								"http://mmbiz.qpic.cn/mmbiz_png/GjIBGyWNnkHvGbiaibKlCog4svFAKmLUn2qUiadlfJ7OxMbsdLyxJ4y7sHZ2tmq1ibcDiaYIoTH4NpdtcZ5OdewGtVw/0?wx_fmt=png");
						a.setTitle("『U家零息贷款』☛ 快速搞定装修款！");
						a.setUrl(
								"http://mp.weixin.qq.com/s?__biz=MzI2OTUxNzQ5OA==&mid=100000007&idx=1&sn=866a774571dc884db59d058beb6b99e9&chksm=6ade56d25da9dfc4709898315dd5c83e37159f9ac77f41dcc298b39a532aa37b8dcefb00b044#rd");
						articles.add(a);
						nm.setArticles(articles);
						nm.setCreateTime(1478084370);
						nm.setFromUserName(developerId);
						nm.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(nm);
					}
					if (EventKey.equals("ufentequan")) {
						NewsMessage nm = new NewsMessage();
						nm.setArticleCount(1);
						List<Article> articles = new ArrayList<>();
						Article a = new Article();
						a.setDescription("到店就能抽取现金红包，100%中奖，最高可达300哦！");
						a.setPicUrl(
								"http://mmbiz.qpic.cn/mmbiz_jpg/GjIBGyWNnkFPZicycMDPF9x4gibJQzJYibesrK9uic6RyW2JmNhk0kBRYv6y8oXfSEnECV4YTxpNarFrKY33iaHhhBA/0?wx_fmt=jpeg");
						a.setTitle("U家5大特权免费享，装修轻松省5000！");
						a.setUrl(
								"http://mp.weixin.qq.com/s?__biz=MzI2OTUxNzQ5OA==&mid=100000480&idx=1&sn=9f4fe794543ad24f963fda0076b19346&chksm=6ade55355da9dc23ee580a8f4b1c9890f3a2f6606694ea7269149051d7bfc07f27d419b03b71#rd");
						articles.add(a);
						nm.setArticles(articles);
						nm.setCreateTime(1488539210);
						nm.setFromUserName(developerId);
						nm.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(nm);
					}
					if (EventKey.equals("chuangyegushi")) {
						NewsMessage nm = new NewsMessage();
						nm.setArticleCount(1);
						List<Article> articles = new ArrayList<>();
						Article a = new Article();
						a.setDescription("曾经那个执念做家装的程序猿，是如何成为家装网红的？");
						a.setPicUrl(
								"http://mmbiz.qpic.cn/mmbiz_png/GjIBGyWNnkFknggk1C0cEx3PPxzm5IPANaJ4QzwysE8mgPib9E4Q5icp9Mxh3PLWlfcUGKBw25QIJmoqvggcymWg/0?wx_fmt=png");
						a.setTitle("曾经那个执念做家装的程序猿，是如何成为家装网红的？");
						a.setUrl(
								"http://mp.weixin.qq.com/s?__biz=MzI2OTUxNzQ5OA==&mid=100000192&idx=1&sn=94fe18a51ba0ff96e7e165cc686a337f&chksm=6ade56155da9df0309808716747afffab7b63cb2444ce9365fd1eca6924117b776a1bf126fdd#rd");
						articles.add(a);
						nm.setArticles(articles);
						nm.setCreateTime(1481263917);
						nm.setFromUserName(developerId);
						nm.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(nm);
					}
					if (EventKey.equals("changjianwenti")) {
						NewsMessage nm = new NewsMessage();
						nm.setArticleCount(1);
						List<Article> articles = new ArrayList<>();
						Article a = new Article();
						a.setDescription("快来了解我们吧~");
						a.setPicUrl(
								"http://mmbiz.qpic.cn/mmbiz_jpg/GjIBGyWNnkHvGbiaibKlCog4svFAKmLUn2aW5yia602dafuK1J5lcZNfL2227deP06IsVlcXdN64yaMicf3k13QH3w/0?wx_fmt=jpeg");
						a.setTitle("关于U家，你想问的都在这里！");
						a.setUrl(
								"http://mp.weixin.qq.com/s?__biz=MzI2OTUxNzQ5OA==&mid=100000005&idx=1&sn=36fb24db8d55ccc4619b68c41f5aebfa&chksm=6ade56d05da9dfc6f4aaf2150bb683a9ccc34274ae2d789b97d277025d36f44e3f43833a4ba2#rd");
						articles.add(a);
						nm.setArticles(articles);
						nm.setCreateTime(1478084013);
						nm.setFromUserName(developerId);
						nm.setToUserName(userOpen_id);
						respMessage = MessageUtil.messageToXml(nm);
					}
					if (EventKey.equals("tiyandian")) {

						ImageMessage im = new ImageMessage();

						im.setCreateTime(1488781497);
						im.setFromUserName(developerId);
						im.setToUserName(userOpen_id);
						Image image = new Image();
						image.setMediaId("FVehsouAN-TJPtGe7S-xnguha6DYzL6AVrXM1JVIOxQ");
						im.setImage(image);
						respMessage = MessageUtil.messageToXml(im);

					}
					if (EventKey.equals("38nvwnagjie")) {
						
						ImageMessage im = new ImageMessage();
						
						im.setCreateTime(1488781497);
						im.setFromUserName(developerId);
						im.setToUserName(userOpen_id);
						Image image = new Image();
						image.setMediaId("FVehsouAN-TJPtGe7S-xnqcuJXy6BNQWplNEZJq7rAw");
						im.setImage(image);
						respMessage = MessageUtil.messageToXml(im);
						
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("respMessage=" + respMessage);
		return respMessage;
	}
}
