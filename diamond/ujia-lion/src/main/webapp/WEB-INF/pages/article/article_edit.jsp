<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<jsp:include page="/resource/plugins/ueditorPlugin.jsp"></jsp:include>
<div style="margin: 15px;">
	<form class="layui-form" id="articleForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">文章标题</label>
			<div class="layui-input-inline">
				<input type="text" name="title" autocomplete="off" class="layui-input" value="">
			</div>			
		</div>
		<div class="layui-form-item">
			
			<label class="layui-form-label">文章封面图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectCoverCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectCoverCallBack(fileUrlArr){
	                	
	                	$("[name='cover_src']").attr("src",fileUrlArr[0]);
	                	$("[name='cover']").val(fileUrlArr[0]);
	                }
                </script>
                <i onclick="clearCover()">清空</i>
				<input type="hidden" name="cover" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="cover_src" src="">
			</div>
			<label class="layui-form-label">文章头图</label>
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
                <i onclick="clearTopCover()">清空</i>
				<input type="hidden" name="topCover" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="topCover_src" src="">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">文章类型</label>
						<div class="layui-input-inline">
							<select name="articleTypeKey">
										<option value="">请选择案例类型</option>
										<option value="0">装前必读</option>
										<option value="1">材料选购</option>
										<option value="2">施工工艺</option>
										<option value="3">设计搭配</option>
										<option value="4">U家故事</option>
							</select>
						</div>

			<label class="layui-form-label">标签</label>
			<div class="layui-input-inline">
				<input type="text" name="tags" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">作者姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="authorName" autocomplete="off" class="layui-input" value="">
			</div>
		
			<label class="layui-form-label">作者头像</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectAuthorAvatarCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectAuthorAvatarCallBack(fileUrlArr){
	                	
	                	$("[name='authorAvatar_src']").attr("src",fileUrlArr[0]);
	                	$("[name='authorAvatar']").val(fileUrlArr[0]);
	                }
                </script>
                 <i onclick="clearAuthorAvatar()">清空</i>
				<input type="hidden" name="authorAvatar" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="authorAvatar_src" src="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章简介</label>
			<div class="layui-input-inline">
				<textarea type="text" name="articleAbstract" autocomplete="off" class="layui-input" value=""/>
			</div>
			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">多媒体资源</label>
			<div class="layui-input-inline">
				<input type="text" name="mediaUrl" autocomplete="off" class="layui-input" value="">
			</div>
			
		</div>
		
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea name="pageContent" id="pageContent" placeholder="请输入内容" class="layui-textarea" ></textarea>
			    <script type="text/javascript">
			        var editor = UE.getEditor('pageContent');
			    </script>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='title']").val(obj.title);
		$("[name='cover']").val(obj.cover);
		$("[name='cover_src']").attr("src",obj.cover);
		$("[name='tags']").val(obj.tags);
		$("[name='articleTypeKey']").val(obj.articleTypeKey);
		$("[name='authorName']").val(obj.authorName);		
		$("[name='authorAvatar']").val(obj.authorAvatar);
		$("[name='authorAvatar_src']").attr("src",obj.authorAvatar);
		$("[name='articleAbstract']").val(obj.articleAbstract);
		$("[name='mediaUrl']").val(obj.mediaUrl);
		$("[name='topCover']").val(obj.topCover);
		$("[name='topCover_src']").attr("src",obj.topCover);
		
		layui.use('form', function() {
				form.render();
			});
		editor.ready(function() { 
			editor.setContent(obj.pageContent); 
		});

	}

</script>