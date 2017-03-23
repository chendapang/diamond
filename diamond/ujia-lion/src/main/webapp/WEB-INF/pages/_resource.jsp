<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" href="/resource/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="/resource/css/global.css" media="all">
<link rel="stylesheet" href="/resource/plugins/font-awesome/css/font-awesome.min.css">

<script type="text/javascript" src="/resource/plugins/layui/layui.js"></script>
<script type="text/javascript" >
layui.config({
	base: '/resource/js/'
});
var $;
layui.use(['jquery'], function() {
	$ = layui.jquery;
	
	$.fn.formToJson = function()//扩展表单内容序列化成json方法
	{
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	
	$.postJson = function(api,jsonObj,successFn,async)
	{
		$.ajax({
				type : "POST",
				url : api,
				async:async,
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify(jsonObj),
				success : function(data) {
					successFn(data);
				}
			});
	};

});

function popConfirm(title,content,func){
	layer.open({
		  title: title,
		  content: content,
		  btn: ['确认', '取消'],
		  btn1:func
	});     
}
</script>