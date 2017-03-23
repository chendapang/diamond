<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<div style="margin: 15px;">
	<form class="layui-form" id="editForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">活动标题</label>
			<div class="layui-input-inline">
				<input type="text" name="title" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">缩略图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectCoverCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectCoverCallBack(fileUrlArr){
	                	
	                	$("[name='thumb_src']").attr("src",fileUrlArr[0]);
	                	$("[name='thumb']").val(fileUrlArr[0]);
	                }
                </script>
                
				<input type="hidden" name="thumb" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="thumb_src" src="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">页面地址</label>
			<div class="layui-input-inline">
				<input type="text" name="href" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">开始时间</label>
			<div class="layui-input-inline">
				<input class="layui-input" name="startTime" id="LAY_demorange_s"  value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">结束时间</label>
			<div class="layui-input-inline">
				<input class="layui-input" name="endTime" id="LAY_demorange_e"  value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">是否精选</label>
			<div class="layui-input-inline">
				<input type="checkbox" name="boutique" lay-skin="switch" value="true" >
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">摘要</label>
			<div class="layui-input-block">
				<textarea name="digest" id="digest" placeholder="请输入内容" class="layui-textarea"  value=""/>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='title']").val(obj.title);
		$("[name='thumb']").val(obj.thumb);
		$("[name='thumb_src']").attr("src",obj.thumb);
		$("[name='href']").val(obj.href);
		$("[name='startTime']").val(obj.startTime);
		$("[name='endTime']").val(obj.endTime);
		$("[name='digest']").val(obj.digest);
		
		if(obj.boutique){
			$("[name='boutique']").attr("checked","checked");
		}
		layui.use('form', function() {
			form.render();
		});
	}
	layui.use(['laydate'], function() {
		
		
		var laydate = layui.laydate;
		var start = {
			max : '2099-06-16 23:59:59',
			format:'YYYY-MM-DD hh:mm:ss',
			festival: true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};
		var end = {
			max : '2099-06-16 23:59:59',
			format:'YYYY-MM-DD hh:mm:ss',
			festival: true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，重置开始日的最大日期
			}
		};
		document.getElementById('LAY_demorange_s').onclick = function() {
			start.elem = this;
			laydate(start);
		}
		document.getElementById('LAY_demorange_e').onclick = function() {
			end.elem = this
			laydate(end);
		}
	});
</script>