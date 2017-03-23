<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<jsp:include page="../_resource.jsp"></jsp:include>
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="caidan" >
	<ul class="layui-tab-title" lay-filter="filter">
		<li class="layui-this" data-name="news">图文消息</li>
		<li data-name="image">图片</li>
		<li data-name="voice">语音</li>
		<li data-name="video">视频</li>
	</ul>
	<div class="layui-tab-content">
		<div class="admin-main">
			<fieldset class="layui-elem-field">
				<legend>数据列表--<font color="red">程序员友情提示：该页面加载比较慢，请耐心等待</font></legend>
				<div class="layui-field-box layui-form">
					<table class="layui-table admin-table">
					<thead>
					<tr>
						<th>
							media_id
						</th>
						<th>
							name
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
	</div>
</div>
	
	<!--模板-->
	<script type="text/html" id="tpl">
			{{# layui.each(d.items, function(index, item){ }}
			<tr>
				<td><input value="{{ item.media_id }}" style="width: 100%;" readonly="readonly"></td>
				<td>{{ item.name }}</td>
			</tr>
			{{# }); }}
	</script>
<script type="text/javascript">
var tabName="news";	
var url_getList = '/wxmanage/getMaterialList';
layui.use(['element','paging','laytpl','form'], function() {
	var element = layui.element();
	var paging = layui.paging();
	var layerTips = parent.layer === undefined ? layui.layer : parent.layer; //获取父窗口的layer对象
	var layer = layui.layer; //获取当前窗口的layer对象
	var form = layui.form();
	
	//分页相关
	paging.init({
		url: url_getList, //地址
		elem: '#content', //内容容器
		params: {"tabName":tabName},
		type: 'GET',
		tempElem: '#tpl', //模块容器
		pageConfig: { //分页参数配置
			elem: '#paged', //分页容器
			pageSize: 5//分页大小
		},
		success: function() { //渲染成功的回调
		},
		fail: function(msg) { //获取数据失败的回调
		},
		complate: function() { //完成的回调
			form.render();
		},
	});
	
	element.on('tab(caidan)', function(data){
		tabName = $(this).attr("data-name");
		paging.init({params: {"tabName":tabName}});
	});
});

</script>
</body>
</html>