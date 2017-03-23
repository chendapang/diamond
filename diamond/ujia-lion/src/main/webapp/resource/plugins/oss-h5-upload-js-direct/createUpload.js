function openUpload(callBackFun){
	
	
	$.get('/resource/plugins/oss-h5-upload-js-direct/uploadFilePlugin.jsp', null, function(formHtml) {
		
		layer.open({
			id: 'uploadDialog',
			type: 1,
			title: "文件上传",
			content: formHtml,
			btn: ['保存', '取消'],
			shade: 0.8,
			area: ['50%', '50%'],
			zIndex: 19950924,
			maxmin: false,
			btn1: function(index) {//按钮1的回调
				var fileUrlArr = getFileUrlArr();
				callBackFun(fileUrlArr);
				layer.close(layer.index);
			},
			success: function(layero, index) {
			},
			end: function() {
			}
		});
	});
	
}
