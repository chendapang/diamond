package com.ujia.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ujia.model.DataDict;
import com.ujia.service.SystemDataDicService;
import com.ujia.utils.wx.Article;
import com.ujia.vo.WxMenuButtonVo;

/**
 * 微信相关工具
 * 
 * @author xx
 *
 */
public class WxUtils {


	static String pattern = "yyyy-MM-dd HH:mm:ss";

	private static SystemDataDicService systemDicService;

	static {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		systemDicService = wac.getBean(SystemDataDicService.class);
	}

	/**
	 * 获取access_token
	 * @return
	 */
	public static String getAccess_token() {
		String access_token = systemDicService.getByKey("access_token");

		if (StringUtils.isNotBlank(access_token)) {

			try {
				String limitTime = systemDicService.getByKey("access_token_limitTime");
				Date limitDate = DateUtils.parseDate(limitTime, pattern);

				// 当前日期小于缓存中的日期，证明没有过期，可以直接返回缓存中的token
				if (new Date().getTime() < limitDate.getTime()) {
					return access_token;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		String urlstr = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		urlstr = urlstr.replace("APPID", systemDicService.getByKey("APPID"));
		urlstr = urlstr.replace("APPSECRET", systemDicService.getByKey("APPSECRET"));

		JSONObject json = UrlRequestWithJson(urlstr, "GET", null);
		if (json == null) {
			return "";
		}

		Object _access_token = json.get("access_token");
		if (_access_token != null) {
			access_token = String.valueOf(_access_token);

			systemDicService.insert(new DataDict(null, "access_token", access_token, "公众号的全局唯一票据"));
			systemDicService.insert(new DataDict(null, "access_token_limitTime",
					DateFormatUtils.format(DateUtils.addMinutes(new Date(), 110), pattern), "创建时间。失效时间为该时间120分钟后(安全起见，数据库中提前10分钟过期)"));
		} else {
			System.out.println("获取 access_token 失败");
		}

		System.out.println("access_token=" + access_token);
		return access_token;
	}

	/**
	 * 请求某个接口的工具
	 * @param url_s
	 * @param method
	 * @param param
	 * @return
	 */
	public static JSONObject UrlRequestWithJson(String url_s, String method, JSONObject param) {
		try {
			URL url = new URL(url_s);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod(method.toUpperCase());

			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");
			http.connect();
			OutputStream os = http.getOutputStream();
			if (param != null) {
				os.write(param.toString().getBytes("UTF-8"));
			}
			os.flush();
			os.close();
			InputStream is = http.getInputStream();
			
			
			
			 byte[] by = new byte[5*1024];
             ByteArrayOutputStream bos = new ByteArrayOutputStream();
             int len = -1;
             while ((len = is.read(by)) != -1) {
                 bos.write(by, 0, len);
             }
             // 关闭流
             is.close();
             String message = bos.toString("utf-8");
			JSONObject json = JSONObject.parseObject(message.toString());
			
			if(json.get("errcode")!=null){
				throw new Exception(json.getString("errmsg"));
			}
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析微信发来的XML请求
	 */
	@SuppressWarnings("all")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {

		// 讲解析结果放入Map中
		Map<String, String> map = new HashMap<String, String>();
		// 从request 中获取输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document documet = reader.read(inputStream);
		// 得到xml根元素
		Element root = documet.getRootElement();
		// 得到根元素所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());
		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}

	/**
	 * 解析微信发来的XML请求
	 */
	@SuppressWarnings("all")
	public static Map<String, String> parseXml(InputStream inputStream) throws Exception {

		// 讲解析结果放入Map中
		Map<String, String> map = new HashMap<String, String>();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document documet = reader.read(inputStream);
		// 得到xml根元素
		Element root = documet.getRootElement();
		// 得到根元素所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());
		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}

	/**
	 * map转xml字符串
	 * 
	 * @param map
	 * @return
	 */
	private static String mapToXmlString(Map<String, Object> map) {
		String strXml = null;
		try {
			Document document = DocumentHelper.createDocument();
			Element xml = document.addElement("xml");

			Collection<String> keyset = map.keySet();
			List<String> list = new ArrayList<String>(keyset);

			for (int i = 0; i < list.size(); i++) {
				if (map.get(list.get(i)) != null) {
					Element e = xml.addElement(list.get(i));
					e.addText(map.get(list.get(i)).toString());
				}
			}
			StringWriter strWriter = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter xmlWriter = new XMLWriter(strWriter, format);
			xmlWriter.write(document);

			strXml = strWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strXml;
	}

	/**
	 * 对map的key进行排序，并生成String用&连接
	 * 
	 * @param map
	 * @return ex:A=a&B=b
	 */
	public static String sortMapToString(Map<String, Object> map) {

		StringBuffer sb = new StringBuffer();

		Set<String> keySet = map.keySet();

		ArrayList<String> keyList = new ArrayList<String>();

		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			keyList.add(key);
		}
		Collections.sort(keyList);

		for (String key : keyList) {
			sb.append("&").append(key).append("=").append(map.get(key));
		}

		return sb.replace(0, 1, "").toString();// 去除第一个&
	}

	/**
	 * 微信支付签名算法
	 * 
	 * @param map
	 *            需要前面的key-value组合（不包含参数key）
	 * @param key
	 *            加在前面末端的key值
	 * @return
	 */
	public static String wxSign(Map<String, Object> map, String key) {
		String stringSignTemp = sortMapToString(map) + "&key=" + key;

		String sign = DigestUtils.md5DigestAsHex(stringSignTemp.getBytes(Charset.forName("UTF-8"))).toUpperCase();

		return sign;
	}

	/**
	 * 发起微信统一支付
	 * 
	 * @param map
	 *            需要前面的key-value组合（不包含参数key）
	 * @param key
	 *            加在前面末端的key值
	 * @return
	 */
	public static Map<String, String> unifiedorder(Map<String, Object> map, String key) {
		String sign = wxSign(map, key);
		map.put("sign", sign);

		String xml = mapToXmlString(map);
		try {
			URL url = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000); // 设置连接主机超时（单位：毫秒)
			conn.setReadTimeout(30000); // 设置从主机读取数据超时（单位：毫秒)
			conn.setDoOutput(true); // post请求参数要放在http正文内，顾设置成true，默认是false
			conn.setDoInput(true); // 设置是否从httpUrlConnection读入，默认情况下是true
			conn.setUseCaches(false); // Post 请求不能使用缓存
			// 设定传送的内容类型是可序列化的java对象(如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("POST");// 设定请求的方法为"POST"，默认是GET
			conn.setRequestProperty("Content-Length", xml.length() + "");
			String encode = "utf-8";
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encode);
			out.write(xml.toString());
			out.flush();
			out.close();
			// 从request 中获取输入流
			InputStream inputStream = conn.getInputStream();

			Map<String, String> parseXmlMap = parseXml(inputStream);

			inputStream.close();
			inputStream = null;
			return parseXmlMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过openid获取用户的基本信息
	 * 
	 * @param openid
	 * @return
	 */
	public static JSONObject getWxInfo(String openid) {
		String url_s = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		url_s = url_s.replace("ACCESS_TOKEN", getAccess_token()).replace("OPENID", openid);

		JSONObject json = UrlRequestWithJson(url_s, "GET", null);

		return json;
	}

	/**
	 * 通过微信返回的code获取openid
	 * 
	 * @param code
	 * @return
	 */
	public static String getOpenid(String code) {

		if (StringUtils.isBlank(code)) {
			return "";
		}
		String url_s = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		url_s = url_s.replace("APPID", systemDicService.getByKey("APPID"))
				.replace("SECRET", systemDicService.getByKey("APPSECRET")).replace("CODE", code);

		JSONObject json = UrlRequestWithJson(url_s, "GET", null);

		if (json == null) {
			return "";
		}

		return json.getString("openid");
	}

	/**
	 * 创建永久二维码
	 * @param scene_str
	 * @return 
	 * ticket
	 * url
	 */
	public static JSONObject createQRcode(String scene_str) {
		String url_s = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
		url_s = url_s.replace("ACCESS_TOKEN", WxUtils.getAccess_token());

		String method = "post";
		JSONObject param = new JSONObject();

		param.put("action_name", "QR_LIMIT_SCENE");
		JSONObject action_info = new JSONObject();
		JSONObject scene = new JSONObject();
		
		scene.put("scene_str", scene_str);
		action_info.put("scene", scene);
		param.put("action_info", action_info);

		JSONObject jsonObject = WxUtils.UrlRequestWithJson(url_s, method, param);
		return jsonObject;
	}

	/**
	 * 获取素材列表，
	 * @param tabName 素材类型 	text,news,image,voice,video;
	 * @param pageIndex
	 * @param pageSize
	 * @return 返回类型参考微信工公众号开发
	 */
	public static JSONObject getMaterialList(String tabName, Integer pageIndex, Integer pageSize) {
		String url_s = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
		url_s = url_s.replace("ACCESS_TOKEN", WxUtils.getAccess_token());

		String method = "post";
		JSONObject param = new JSONObject();

		param.put("type", tabName);
		param.put("offset", (pageIndex - 1) * pageSize);
		param.put("count", pageSize);

		JSONObject jsonObject = WxUtils.UrlRequestWithJson(url_s, method, param);
		System.out.println(jsonObject);
		return jsonObject;
	}

	/**
	 * 创建菜单
	 * @param buttons
	 * @return
	 */
	public static JSONObject createMenu(List<WxMenuButtonVo> buttons) {
		String url_s = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url_s = url_s.replace("ACCESS_TOKEN", WxUtils.getAccess_token());

		String method = "post";
		JSONObject param = new JSONObject();

		param.put("button", buttons);

		JSONObject jsonObject = WxUtils.UrlRequestWithJson(url_s, method, param);
		return jsonObject;
	}

	public static List<Article> getArticlesByMediaId(String mediaId) {
		
		String url_s = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
		url_s = url_s.replace("ACCESS_TOKEN", WxUtils.getAccess_token());
		String method = "post";
		JSONObject param = new JSONObject();
		param.put("media_id", mediaId);
		JSONObject jsonObject = WxUtils.UrlRequestWithJson(url_s, method, param);
		
		
		JSONArray news_item = jsonObject.getJSONArray("news_item");
		
		List<Article> articles = new ArrayList<>();
		
		for (Object object : news_item) {
			JSONObject item = (JSONObject)object;
			
			Article a = new Article();
			
			a.setDescription(item.getString("digest"));
			a.setPicUrl(item.getString("thumb_url"));
			a.setTitle(item.getString("title"));
			a.setUrl(item.getString("url"));
			
			articles.add(a);
		}
		
		
		
		return articles;
	}

	/**
	 * 订单状态改变后，发送给用户的消息
	 * 
	 * @param openId
	 *            用户openif
	 * @param msg
	 *            发送的信息
	 * @param orderId
	 *            订单id
	 */
	// private static String
	// TEMPLATE_ChangedOrderStatus="iulo8EM_0I_2NZh80HTEMAjsFVFoxH7sAhU_laVHqMs";
	// public static void sendMsgToWxUser_ChangedOrderStatus(OrdersVO ordersVO)
	// {
	// String openId = ordersVO.getBuyerAccount();
	// if (StringUtils.isBlank(openId )) {
	// return;
	// }
	// String url_s =
	// "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	// url_s = url_s.replace("ACCESS_TOKEN", getAccess_token());
	// JSONObject param = new JSONObject();
	//
	// param.put("touser", openId);
	// param.put("template_id", TEMPLATE_ChangedOrderStatus);
	// param.put("url", PropertiesUtils.get("WXURL") +
	// "/wx/shoppayInfo_check.htm?ordersNumber=" + ordersVO.getOrdersNumber());
	// param.put("topcolor", "#FF0000");
	//
	// JSONObject msgData = new JSONObject();
	// JSONObject msgObject = new JSONObject();
	// msgObject.put("value", "您的订单状态改变，请注意查看");
	// msgObject.put("color", "#FF0000");
	//
	// JSONObject firstObject = new JSONObject();
	// firstObject.put("value", "尊敬的【" + ordersVO.getBuyerName() + "】");
	// firstObject.put("color", "#FF0000");
	//
	// JSONObject OrderSnObject = new JSONObject();
	// OrderSnObject.put("value", ordersVO.getO	rdersNumber());
	// OrderSnObject.put("color", "#FF0000");
	//
	// JSONObject OrderStatusObject = new JSONObject();
	// OrderStatusObject.put("value", ordersVO.getStatusString());
	// OrderStatusObject.put("color", "#FF0000");
	//
	// msgData.put("first", firstObject);
	// msgData.put("OrderSn", OrderSnObject);
	// msgData.put("OrderStatus", OrderStatusObject);
	// msgData.put("remark", msgObject);
	//
	// param.put("data", msgData);
	//
	// UrlRequestWithJson(url_s, "POST", param);
	//
	// }
}
