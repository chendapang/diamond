package com.ujia.lion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.lion.model.NavModel;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/data")
public class SystemDataController {

	@RequestMapping(value = "/nav", method = RequestMethod.GET)
	@ResponseBody
	public Object index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		List<NavModel> parents = new ArrayList<>();

		{
			NavModel parent = new NavModel();
			parent.setTitle("发现页管理");
			parent.setIcon("fa-cubes");
			List<NavModel> children = new ArrayList<>();
			{
				NavModel child = new NavModel();
				child.setTitle("活动列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/activity/activity_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("案例列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/case/case_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("文章列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/article/article_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("工地列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/construct/construct_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("预约列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/order/order_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("轮播列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/banner/banner_list");
				children.add(child);
			}
			parent.setChildren(children);
			parents.add(parent);
		}
		{
			NavModel parent = new NavModel();
			parent.setTitle("微信公众号管理");
			parent.setIcon("fa-cubes");
			List<NavModel> children = new ArrayList<>();
			{
				NavModel child = new NavModel();
				child.setTitle("素材列表");
				child.setIcon("&#xe641;");
				child.setHref("/page/wxmanage/material_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("自动回复");
				child.setIcon("&#xe641;");
				child.setHref("/page/wxmanage/auto_reply_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("自定义菜单");
				child.setIcon("&#xe641;");
				child.setHref("/page/wxmanage/menu_list");
				children.add(child);
			}
			{
				NavModel child = new NavModel();
				child.setTitle("渠道二维码");
				child.setIcon("&#xe641;");
				child.setHref("/page/wxmanage/qrcode_list");
				children.add(child);
			}
			parent.setChildren(children);
			parents.add(parent);
		}
		return parents;
	}

}
