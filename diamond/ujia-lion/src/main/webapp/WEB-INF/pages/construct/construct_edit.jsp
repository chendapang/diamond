<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<jsp:include page="/resource/plugins/ueditorPlugin.jsp"></jsp:include>
<div style="margin: 15px;">
	<form class="layui-form" id="constructForm">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">封面图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectCoverCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectCoverCallBack(fileUrlArr){
	                	
	                	$("[name='picCover_src']").attr("src",fileUrlArr[0]);
	                	$("[name='picCover']").val(fileUrlArr[0]);
	                }
                </script>
                <i onclick="clearCover()">清空</i>
				<input type="hidden" name="picCover" required lay-verify="required" autocomplete="off" class="layui-input"  value="">
			</div>
			<div class="layui-input-inline">
				<img width="100" height="100" name="picCover_src" src="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">工程名称</label>
			<div class="layui-input-inline">
				<input type="text" name="projectName" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">工程地址</label>
			<div class="layui-input-inline">
				<input type="text" name="address" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">面积</label>
			<div class="layui-input-inline">
				<input type="text" name="area" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">花费</label>
			<div class="layui-input-inline">
				<input type="text" name="cost" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">经度</label>
			<div class="layui-input-inline">
				<input type="text" name="lat" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">纬度</label>
			<div class="layui-input-inline">
				<input type="text" name="lng" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">工程状态</label>
			<div class="layui-input-inline">
				<input type="text" name="constuctionStatus" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">详细图</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectDetailPicCallBack)">
					<i class="layui-icon">上传图片</i>
				</button>
				<script type="text/javascript">
	                function selectDetailPicCallBack(fileUrlArr){
	                	
	                	for(var i=0;i<fileUrlArr.length;i++){
	                		var index=0;
	                		var picUrls=$("#detailPics").find("img").length;
	                		
	                		if(picUrls>0){
	                			index=index+picUrls;
	                		}
	                		
		                	var str='<div><input type="hidden" name="picUrlList" required lay-verify="required" autocomplete="off" class="layui-input"  value="'+fileUrlArr[i]+'">'+
		                	'<img width="100" height="100" name="picUrls_src" src="'+fileUrlArr[i]+'"><a onclick="remove(this)">删除</a></div>';
		                	
		                	$("#detailPics").append(str);
	                	}
	                	
	                }
                </script>
                
				
			</div>
			<div class="layui-input-inline">
			    <div id="detailPics"></div>
				
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='picCover']").val(obj.picCover);
		$("[name='picCover_src']").attr("src",obj.picCover);
		$("[name='projectName']").val(obj.projectName);
		$("[name='address']").val(obj.address);
		$("[name='area']").val(obj.area);
		$("[name='cost']").val(obj.cost);
		$("[name='lat']").val(obj.lat);
		$("[name='lng']").val(obj.lng);
		$("[name='constuctionStatus']").val(obj.constuctionStatus);
		
		for(var i=0;i<obj.picUrlList.length;i++){
			var str='<div><input type="hidden" name="picUrlList" required lay-verify="required" autocomplete="off" class="layui-input"  value="'+obj.picUrlList[i]+'">'+
        	'<img width="100" height="100" name="picUrls_src" src="'+obj.picUrlList[i]+'"><a onclick="remove(this)">删除</a></div>';
        	
        	$("#detailPics").append(str);
		}

		 layui.use('form', function() {
				form.render();
			});
	

	}

</script>