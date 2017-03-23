<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="../_resource.jsp"></jsp:include>
<link rel="stylesheet" href="/resource/css/table.css"/>
</head>
<body>
<div class="admin-main">
	<blockquote class="layui-elem-quote">
		<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
		<i class="layui-icon">&#xe608;</i> 添加信息
		</a>
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
					用户输入
				</th>
				<th>
					系统回复类型
				</th>
				<th>
					系统回复内容
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
				<td>{{ item.userInput }}</td>
				<td>{{ item.msgTypeString }}</td>
				<td>{{ item.sysReply }}</td>
				<td>
					<a href="{{ item.href }}" target="_blank" class="layui-btn layui-btn-normal layui-btn-mini">预览</a>
					<a href="javascript:;" data-id="{{ item.id }}" data-opt="edit" class="layui-btn layui-btn-mini">编辑</a>
					<a href="javascript:;" data-id="{{ item.id }}" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
			{{# }); }}
</script>
<script type="text/javascript">
var url_getList = '/autoReply/getList';
var url_getEditPage = '/page/wxmanage/auto_reply_edit';
var url_doGet= "/autoReply/doGet";
var url_doDelete= "/autoReply/doDelete";
var url_doEdit= "/autoReply/doEdit";

layui.use(['paging', 'form','laytpl'], function() {
	paging = layui.paging();
	layerTips = parent.layer === undefined ? layui.layer : parent.layer; //获取父窗口的layer对象
	layer = layui.layer; //获取当前窗口的layer对象
	form = layui.form();

//分页相关
paging.init({
	url: url_getList, //地址
	elem: '#content', //内容容器
	params: { 
		
	},
	openWait:true,
	type: 'GET',
	tempElem: '#tpl', //模块容器
	pageConfig: { //分页参数配置
		elem: '#paged', //分页容器
		pageSize: 6 //分页大小
	},
	success: function() { //渲染成功的回调
	},
	fail: function(msg) { //获取数据失败的回调
	},
	complate: function() { //完成的回调
		form.render();
		bindEvent();
	},
});
//分页相关 end

$('#add').on('click', function() {//因为添加按钮在列表外面，只会刷新一次，所以不需要动态绑定
	$.get(url_getEditPage, null, function(formHtml) {
			popEditDialog("添加活动",formHtml);
	});
});
$("#search").on('click',function(){
	
	layer.msg("功能开发中。。。");
});

//由于页面多数元素是动态生成的，所以绑定事件均写到这里
function bindEvent(){
	$('[data-opt="edit"]').on('click', function() {
		var id = $(this).data("id");
		$.get(url_getEditPage, null, function(formHtml) {//获取表单模板
			
			  $.get(url_doGet,{"id":id},function(result){//获取数据
				 var obj =  result.data;
				 popEditDialog("编辑活动",formHtml);
				 fillForm(obj)//调用页面的填充数据方法
			  });
		});
	});
	$('[data-opt="del"]').on('click', function() {
		var id = $(this).data("id");
		popConfirm("确认删除？","删除后不可回复，请确认",function(){
			$.postJson(url_doDelete,{"id":id},function(result){
				if(result.success){
					layer.msg("删除成功");
					paging.init();//刷新分页
				}else{
					layer.msg(result.errorMSG);
				}
			});
		});
	});
}

function popEditDialog(title,html){//弹出编辑对话框
	layer.open({
		id: 'edit_dialog',
		type: 1,
		title: title,
		content: html,
		shade: 0.8,
		area: ['80%', '80%'],
		zIndex: 19950924,
		maxmin: true,
		btn: ['保存', '取消'],
		btn1: function(index) {//按钮1的回调 从1开始
			var formData = $("#editForm").formToJson();		
			$.postJson(url_doEdit,formData,function(result){
				if(result.success){
					layer.close(layer.index);
					paging.init();//刷新分页
					layer.msg("保存成功");
				}else{
					layer.msg(result.errorMSG);
				}
			});
		},
		success: function(layero, index) {
			//弹出窗口成功后渲染表单
			var form = layui.form();
			form.render();
		},
		end: function() {
		}
	});
}
});

</script>
</body>
</html>