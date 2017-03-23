<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<jsp:include page="/resource/plugins/ueditorPlugin.jsp"></jsp:include>
<div style="margin: 15px;">
	<form class="layui-form" id="orderForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">联系方式</label>
			<div class="layui-input-inline">
				<input type="text" name="contact" autocomplete="off" class="layui-input" value="" readonly>
			</div>
			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">工地名称</label>
			<div class="layui-input-inline">
				<input type="text" name="building" autocomplete="off" class="layui-input" value="" readonly>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">预约类型</label>
			<div class="layui-input-inline">
				<input type="text" name="typeStr" autocomplete="off" class="layui-input" value="" readonly>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">设计师姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="designerName" autocomplete="off" class="layui-input" value="" readonly>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-inline">
				<select name="status" readonly>
							<option value="0">未处理</option>
							<option value="1">已处理</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<textarea type="text" name="comment" autocomplete="off" class="layui-input" value=""/>
			</div>
			
		</div>
		
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='contact']").val(obj.contact);
		$("[name='building']").val(obj.building);
		$("[name='designerName']").val(obj.designerName);
		$("[name='typeStr']").val(obj.typeStr);		
		$("[name='comment']").val(obj.comment);
		$("[name='status'] option[value='"+obj.status+"']").attr("selected","selected");
		
		layui.use('form', function() {
				form.render();
				
			});

	}

</script>