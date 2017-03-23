<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="../_resource.jsp"></jsp:include>
<link rel="stylesheet" href="/resource/css/table.css"/>
<script type="text/javascript" src="/js/construct.js"></script>
</head>
<body>
<div class="admin-main">
	<blockquote class="layui-elem-quote">
		<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
		<i class="layui-icon">&#xe608;</i> 添加信息
		</a>
		 工地名称:
	   	<input type="text" value="" id="projectName">
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
					封面图
				</th>
				<th>
					工地名称
				</th>
				<th>
					地址
				</th>
				
				<th>
					面积
				</th>
				<th>
					花费
				</th>
				<th>
					装修状态
				</th>
				<th>
					图片数量
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
				<td><img src="{{ item.picCover }}" width="50" height="50"></td>
				<td>{{ item.projectName }}</td>
				<td>{{ item.address }}</td>
				<td>{{ item.area }}</td>
				<td>{{ item.cost }}</td>
				<td>{{ item.constuctionStatus }}</td>
				<td>{{ item.picAmount }}</td>
				<td>
					<a href="{{ item.href }}" target="_blank" class="layui-btn layui-btn-normal layui-btn-mini">预览</a>
					<a href="javascript:;" data-id="{{ item.id }}" data-opt="edit" class="layui-btn layui-btn-mini">编辑</a>
					<a href="javascript:;" data-id="{{ item.id }}" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
			{{# }); }}
</script>
</body>
</html>