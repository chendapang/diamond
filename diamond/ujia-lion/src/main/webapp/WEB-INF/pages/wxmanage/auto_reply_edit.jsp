<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="margin: 15px;">
	<form class="layui-form" id="editForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">用户输入</label>
			<div class="layui-input-inline">
				<input type="text" name="userInput" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">系统回复类型 </label>
			<div class="layui-input-inline">
			<select name="msgType" lay-verify="required">
				<option value="text">文字</option>
				<option value="news">图文消息</option>
				<option value="image">图片</option>
				<option value="voice">语音</option>
				<option value="video">视频</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">系统回复内容 </label>
			<div class="layui-input-inline">
				<textarea name="sysReply" id="sysReply" placeholder="请输入内容" class="layui-textarea"  value=""/>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='userInput']").val(obj.userInput);
		$("[name='msgType']").val(obj.msgType);
		$("[name='sysReply']").val(obj.sysReply);
		
		layui.use('form', function() {
			form.render();
		});
	}
</script>