<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="../_resource.jsp"></jsp:include>
<link rel="stylesheet" href="/resource/css/table.css"/>
<script type="text/javascript" src="/js/order.js"></script>
</head>
<body>
<div class="admin-main">
	<blockquote class="layui-elem-quote">
	   	 联系方式:
	   	 <input type="text" value="" id="contact">
	   	 预约类型: 
	   	<select id="type" >
	   			<option value="">请选择</option>
				<option value="0">普通</option>
				<option value="1">预约设计师</option>
				<option value="2">预约看工地</option>
		</select>
		<a href="javascript:;" class="layui-btn layui-btn-small" id="search">
		<i class="layui-icon">&#xe615;</i> 搜索
		</a>
	</blockquote>
	<fieldset class="layui-elem-field">
		<legend>数据列表</legend>
		<div class="layui-field-box layui-form">
			<table class="layui-table admin-table">
			<thead>
			<tr>
				<th style="width: 30px;">
					<input type="checkbox" lay-filter="allselector" lay-skin="primary">
				</th>
				<th>
					联系方式
				</th>
				<th>
					工地名称
				</th>
				<th>
					预约类型
				</th>
				<th>
					预约时间
				</th>
				<th>
					状态
				</th>
				<th>
					操作
				</th>
			</tr>
			</thead>
			<tbody id="content">
			</tbody>
			</table>
		</div>
	</fieldset>
	<div class="admin-table-page">
		<div id="paged" class="page">
		</div>
	</div>
</div>

<!--模板-->
<script type="text/html" id="tpl">
			{{# layui.each(d.items, function(index, item){ }}
			<tr>
				<td><input type="checkbox" lay-skin="primary"></td>
				<td>{{ item.contact }}</td>
				<td>{{ item.building }}</td>
				<td>{{ item.typeStr }}</td>
				<td>{{ item.createdAt }}</td>
				<td>{{ item.statusStr }}</td>
				<td>
					<a href="javascript:;" data-id="{{ item.id }}" data-opt="edit" class="layui-btn layui-btn-mini">编辑</a>
				</td>
			</tr>
			{{# }); }}
</script>
</body>
</html>