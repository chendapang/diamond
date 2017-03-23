layui.use(['paging', 'form','laytpl'], function() {
		paging = layui.paging();
		layerTips = parent.layer === undefined ? layui.layer : parent.layer; //获取父窗口的layer对象
		layer = layui.layer; //获取当前窗口的layer对象
		form = layui.form();
	
	//分页相关
	paging.init({
		url: '/case/getList', //地址
		elem: '#content', //内容容器
		params: { 
			
		},
		type: 'GET',
		openWait:true,
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
		$.get('/page/case/case_edit', null, function(formHtml) {
				popEditDialog("添加案例",formHtml);
		});
	});
	$("#search").on('click',function(){
		
		layer.msg("功能开发中。。。");
	});
	
	//由于页面多数元素是动态生成的，所以绑定事件均写到这里
	function bindEvent(){
		$('[data-opt="edit"]').on('click', function() {
			var id = $(this).data("id");
			$.get('/page/case/case_edit', null, function(formHtml) {//获取表单模板
				
				  $.get("/case/doGet",{"id":id},function(result){//获取数据
					 var obj =  result.data;
					 popEditDialog("编辑案例",formHtml);
					 fillForm(obj)//调用页面的填充数据方法
				  });
			});
		});
		$('[data-opt="del"]').on('click', function() {
			var id = $(this).data("id");
			popConfirm("确认删除？","删除后不可回复，请确认",function(){
				$.postJson("/case/doDelete",{"id":id},function(result){
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
			id: 'case_edit',
			type: 1,
			title: title,
			content: html,
			shade: 0.8,
			area: ['80%', '80%'],
			zIndex: 19950924,
			maxmin: true,
			btn: ['保存', '取消'],
			btn1: function(index) {//按钮1的回调 从1开始
				var formData = $("#caseForm").formToJson();		
	
				$.postJson("/case/doEdit",formData,function(result){
					if(result.success){
						layer.msg("保存成功");
						layer.close(layer.index);
						paging.init();//刷新分页
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

function clearCover(){
	$("[name='coverUrl']").val("");
	$("[name='cover_src']").attr("src","");
}

function clearDesignerAvatar(){
	$("[name='designerAvatar']").val("");
	$("[name='designerAvatar_src']").attr("src","");
}

function clearTopCover(){
	$("[name='topCover']").val("");
	$("[name='topCover_src']").attr("src","");
}



