<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<jsp:include page="/resource/plugins/ueditorPlugin.jsp"></jsp:include>
<div style="margin: 15px;">
	<form class="layui-form" id="caseForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">案例标题</label>
			<div class="layui-input-inline">
				<input type="text" name="caption" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">案例封面图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectCoverCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectCoverCallBack(fileUrlArr){
	                	
	                	$("[name='cover_src']").attr("src",fileUrlArr[0]);
	                	$("[name='coverUrl']").val(fileUrlArr[0]);
	                }
                </script>
                
				<input type="hidden" name="coverUrl" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
				<i onclick="clearCover()">清空</i>
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="cover_src" src="">
			</div>
			<label class="layui-form-label">案例头图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectTopCoverCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectTopCoverCallBack(fileUrlArr){
	                	
	                	$("[name='topCover_src']").attr("src",fileUrlArr[0]);
	                	$("[name='topCover']").val(fileUrlArr[0]);
	                }
                </script>
                
				<input type="hidden" name="topCover" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
				<i onclick="clearTopCover()">清空</i>
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="topCover_src" src="">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">案例类型</label>
			<div class="layui-input-inline">
				<select name="type">
							<option value="">请选择案例类型</option>
							<option value="0">日式</option>
							<option value="1">北欧</option>
							<option value="2">现代</option>
							<option value="3">轻美式</option>
							<option value="4">混搭</option>
							<option value="5">轻工业</option>
				</select>
			</div>
		
			<label class="layui-form-label">作者</label>
			<div class="layui-input-inline">
				<input type="text" name="author" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">标签</label>
			<div class="layui-input-inline">
				<input type="text" name="tag" autocomplete="off" class="layui-input" value="">
			</div>
		
		</div>
	<div class="layui-form-item">
					<label class="layui-form-label">是否推荐</label>
					<div class="layui-input-block">
						<input type="radio" name="recommend" value="0" title="否" checked >
						<input type="radio" name="recommend" value="1" title="是">
					</div>
				</div>
		<div class="layui-form-item">
			<label class="layui-form-label">案例简介</label>
			<div class="layui-input-inline">
				<input type="text" name="caseAbstract" autocomplete="off" class="layui-input" value="">
			</div>
			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">工地名称</label>
			<div class="layui-input-inline">
				<input type="text" name="buildingName" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">户型</label>
			<div class="layui-input-inline">
				<input type="text" name="houseStyle" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">面积</label>
			<div class="layui-input-inline">
				<input type="text" name="houseArea" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">花费</label>
			<div class="layui-input-inline">
				<input type="text" name="costAmount" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">设计师姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="designerName" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">设计师头像</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectDesignerAvatarCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectDesignerAvatarCallBack(fileUrlArr){
	                	
	                	$("[name='designerAvatar_src']").attr("src",fileUrlArr[0]);
	                	$("[name='designerAvatar']").val(fileUrlArr[0]);
	                }
                </script>
                <i onclick="clearDesignerAvatar()">清空</i>
				<input type="hidden" name="designerAvatar" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
				<div class="layui-input-inline">
				<img width="100" height="100" name="designerAvatar_src" src="">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea name="context" id="context" placeholder="请输入内容" class="layui-textarea" ></textarea>
			    <script type="text/javascript">
			        var editor = UE.getEditor('context');
			    </script>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='caption']").val(obj.caption);
		$("[name='caseAbstract']").val(obj.caseAbstract);
		$("[name='coverUrl']").val(obj.coverUrl);
		$("[name='cover_src']").attr("src",obj.coverUrl);
		$("[name='author']").val(obj.author);
		
		$("[name='tag']").val(obj.tag);
		$("[name='buildingName']").val(obj.buildingName);
		$("[name='houseStyle']").val(obj.houseStyle);
		$("[name='houseArea']").val(obj.houseArea);
		$("[name='costAmount']").val(obj.costAmount);
		$("[name='designerName']").val(obj.designerName);
		$("[name='designerAvatar']").val(obj.designerAvatar);
		$("[name='designerAvatar_src']").attr("src",obj.designerAvatar);
		$("[name='topCover']").val(obj.topCover);
		$("[name='topCover_src']").attr("src",obj.topCover);
		
		
		$("[name='type'] option[value='"+obj.type+"']").attr("selected","selected");

		 $("[name='recommend']").each(function(){
			 	if($(this).val()==obj.recommend){
			 		$(this).attr("checked","checked");
			 		return;
			 	}
			 	
				if($(this).val()==obj.recommend){
			 		$(this).attr("checked","checked");
			 	}
			    
			  });
		 layui.use('form', function() {
				form.render();
			});
		editor.ready(function() { 
			editor.setContent(obj.context); 
		});

	}

</script>