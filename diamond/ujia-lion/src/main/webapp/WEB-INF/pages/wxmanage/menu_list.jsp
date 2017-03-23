<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="../_resource.jsp"></jsp:include>
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="caidan">
<button class="layui-btn" id="saveBTN">点我保存菜单</button>
	<ul class="layui-tab-title" lay-filter="filter">
		<li class="layui-this">菜单1</li>
		<li>菜单2</li>
		<li>菜单3</li>
	</ul>
	<div class="layui-tab-content">
		<div class="layui-tab-item layui-show">
		<form class="layui-form" id="form0">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单1名称</label>
				<div class="layui-input-inline">
					<input type="text" name="button[0].name" autocomplete="off" class="layui-input" value="">
				</div>
			</div>
			<fieldset class="layui-elem-field">
				<legend>下级菜单1</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[0].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[0].sub_button[0].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[0].sub_button[0].key" autocomplete="off" class="layui-input" value="sub_button_0_0">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[0].sub_button[0].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[0].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[0].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单2</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[1].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[0].sub_button[1].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[0].sub_button[1].key" autocomplete="off" class="layui-input" value="sub_button_0_1">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[0].sub_button[1].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[1].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[1].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单3</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[2].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[0].sub_button[2].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[0].sub_button[2].key" autocomplete="off" class="layui-input" value="sub_button_0_2">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[0].sub_button[2].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[2].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[2].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单4</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[3].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[0].sub_button[3].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[0].sub_button[3].key" autocomplete="off" class="layui-input" value="sub_button_0_3">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[0].sub_button[3].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[3].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[3].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单5</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[4].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[0].sub_button[4].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[0].sub_button[4].key" autocomplete="off" class="layui-input" value="sub_button_0_4">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[0].sub_button[4].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[4].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[0].sub_button[4].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
		</form>
		</div>
		
		<div class="layui-tab-item">
		<form class="layui-form" id="form1">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单2名称</label>
				<div class="layui-input-inline">
					<input type="text" name="button[1].name" autocomplete="off" class="layui-input" value="">
				</div>
			</div>
			<fieldset class="layui-elem-field">
				<legend>下级菜单1</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[0].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[1].sub_button[0].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[1].sub_button[0].key" autocomplete="off" class="layui-input" value="sub_button_1_0">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[1].sub_button[0].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[0].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[0].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单2</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[1].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[1].sub_button[1].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[1].sub_button[1].key" autocomplete="off" class="layui-input" value="sub_button_1_1">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[1].sub_button[1].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[1].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[1].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单3</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[2].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[1].sub_button[2].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[1].sub_button[2].key" autocomplete="off" class="layui-input" value="sub_button_1_2">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[1].sub_button[2].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[2].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[2].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单4</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[3].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[1].sub_button[3].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[1].sub_button[3].key" autocomplete="off" class="layui-input" value="sub_button_1_3">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[1].sub_button[3].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[3].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[3].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单5</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[4].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[1].sub_button[4].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[1].sub_button[4].key" autocomplete="off" class="layui-input" value="sub_button_1_4">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[1].sub_button[4].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[4].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[1].sub_button[4].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
		</form>
		</div>
		
		
		<div class="layui-tab-item">
		<form class="layui-form" id="form2">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单3名称</label>
				<div class="layui-input-inline">
					<input type="text" name="button[2].name" autocomplete="off" class="layui-input" value="">
				</div>
			</div>
			<fieldset class="layui-elem-field">
				<legend>下级菜单1</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[0].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[2].sub_button[0].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[2].sub_button[0].key" autocomplete="off" class="layui-input" value="sub_button_2_1">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[2].sub_button[0].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[0].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[0].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单2</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[1].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[2].sub_button[1].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[2].sub_button[1].key" autocomplete="off" class="layui-input" value="sub_button_2_1">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[2].sub_button[1].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[1].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[1].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单3</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[2].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[2].sub_button[2].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[2].sub_button[2].key" autocomplete="off" class="layui-input" value="sub_button_2_2">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[2].sub_button[2].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[2].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[2].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单4</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[3].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[2].sub_button[3].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[2].sub_button[3].key" autocomplete="off" class="layui-input" value="sub_button_2_3">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[2].sub_button[3].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[3].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[3].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>下级菜单5</legend>
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[4].name" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">菜单类型</label>
					<div class="layui-input-inline">
							<select name="button[2].sub_button[4].type" lay-verify="required">
								<option value="click">文字(只填写内容)</option>
								<option value="media_id">媒体(只填写media_id)</option>
								<option value="view">跳转(只填写url)</option>
							</select>
					</div>
				</div>	
				<div class="layui-form-item">
					<input type="hidden" name="button[2].sub_button[4].key" autocomplete="off" class="layui-input" value="sub_button_2_4">
					<label class="layui-form-label">回复内容</label>
					<div class="layui-input-inline">
						<textarea name="button[2].sub_button[4].reply" placeholder="请输入内容" class="layui-textarea"  value=""></textarea>
					</div>
					<label class="layui-form-label">media_id</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[4].media_id" autocomplete="off" class="layui-input" value="">
					</div>
					<label class="layui-form-label">url</label>
					<div class="layui-input-inline">
						<input type="text" name="button[2].sub_button[4].url" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
			</fieldset>
		</form>
		</div>
	</div>
</div>
<script type="text/javascript">

var url_getList = '/wxmanage/getMenuList';
var url_doEdit= "/wxmanage/saveMenu";

layui.use(['element','laytpl','form'], function() {
	 element = layui.element();
	 layerTips = parent.layer === undefined ? layui.layer : parent.layer; //获取父窗口的layer对象
	 layer = layui.layer; //获取当前窗口的layer对象
	 form = layui.form();
	
	 
	 layer.msg('数据加载中。。。', {
	        time: 20000, //20s后自动关闭
      });
		$.get(url_getList,function(result){
			if(result.success){
				var buttonArr = result.data;
				for(var i=0;i<buttonArr.length;i++){
					var o = buttonArr[i];
					$("[name='button["+i+"].name']").val(o.name);
					
					var sub_button = o.sub_button;
					for(var j =0;j<sub_button.length;j++){
						var so = sub_button[j];
						$("[name='button["+i+"].sub_button["+j+"].name']").val(so.name);
						$("[name='button["+i+"].sub_button["+j+"].type']").val(so.type);
						$("[name='button["+i+"].sub_button["+j+"].reply']").val(so.reply);
						$("[name='button["+i+"].sub_button["+j+"].media_id']").val(so.media_id);
						$("[name='button["+i+"].sub_button["+j+"].url']").val(so.url);
					}
					
				}
			}else{
				layer.msg(result.errorMSG);
			}
			layer.close(layer.index);//数据加载完之后关闭弹出层
			form.render();
		});
	
	$("#saveBTN").click(function(){
		var f0 = $("#form0").formToJson();
		var f1 = $("#form1").formToJson();
		var f2 = $("#form2").formToJson();
		
		var btn0 = new Object();
		var btn1 = new Object();
		var btn2 = new Object();
		
		btn0.name = f0["button[0].name"];
		btn1.name = f1["button[1].name"];
		btn2.name = f2["button[2].name"];
		
		var sub_button0 = new Array();
		var sub_button1 = new Array();
		var sub_button2 = new Array();
	
		btn0.sub_button = sub_button0;
		btn1.sub_button = sub_button1;
		btn2.sub_button = sub_button2;

		var buttonArr = new Array();
		buttonArr.push(btn0);
		buttonArr.push(btn1);
		buttonArr.push(btn2);
		
		for (var i = 0; i < 5; i++) {
			var sBTN = new Object();
			sBTN.name = f0["button[0].sub_button["+i+"].name"];
			sBTN.type = f0["button[0].sub_button["+i+"].type"];
			sBTN.key = f0["button[0].sub_button["+i+"].key"];
			sBTN.media_id = f0["button[0].sub_button["+i+"].media_id"];
			sBTN.url = f0["button[0].sub_button["+i+"].url"];
			sBTN.reply = f0["button[0].sub_button["+i+"].reply"];
			sub_button0.push(sBTN);
			
			var sBTN = new Object();
			sBTN.name = f1["button[1].sub_button["+i+"].name"];
			sBTN.type = f1["button[1].sub_button["+i+"].type"];
			sBTN.key = f1["button[1].sub_button["+i+"].key"];
			sBTN.media_id = f1["button[1].sub_button["+i+"].media_id"];
			sBTN.url = f1["button[1].sub_button["+i+"].url"];
			sBTN.reply = f1["button[1].sub_button["+i+"].reply"];
			sub_button1.push(sBTN);
			
			var sBTN = new Object();
			sBTN.name = f2["button[2].sub_button["+i+"].name"];
			sBTN.type = f2["button[2].sub_button["+i+"].type"];
			sBTN.key = f2["button[2].sub_button["+i+"].key"];
			sBTN.media_id = f2["button[2].sub_button["+i+"].media_id"];
			sBTN.url = f2["button[2].sub_button["+i+"].url"];
			sBTN.reply = f2["button[2].sub_button["+i+"].reply"];
			sub_button2.push(sBTN);

		}
		
		
		$.postJson(url_doEdit,buttonArr,function(result){
			if(result.success){
				layer.msg("保存成功");
				location.href=location.href;
			}else{
				layer.msg(result.errorMSG);
			}
		});
	});

				

});
</script>
</body>
</html>