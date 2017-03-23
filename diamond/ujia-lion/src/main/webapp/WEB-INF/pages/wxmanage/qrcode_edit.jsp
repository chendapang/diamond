<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="margin: 15px;">
	<form class="layui-form" id="editForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">二维码名称</label>
			<div class="layui-input-inline">
				<input type="text" name="name" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">回复类型</label>
			<div class="layui-input-inline">
				<select name="replyType" lay-verify="required">
					<option value="text">文字(直接在内容中填写回复文字)</option>
					<option value="news">图文消息(内容中填入media_id)</option>
					<option value="image">图片(内容中填入media_id)</option>
					<option value="voice">语音(内容中填入media_id)</option>
					<option value="video">视频(内容中填入media_id)</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">内容 </label>
			<div class="layui-input-inline">
				<textarea name="content" id="content" placeholder="请输入内容" class="layui-textarea"  value=""/>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='name']").val(obj.name);
		$("[name='replyType']").val(obj.replyType);
		$("[name='content']").val(obj.content);
		
		layui.use('form', function() {
			form.render();
		});
	}
</script>