<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/createUpload.js"></script>
<jsp:include page="/resource/plugins/ueditorPlugin.jsp"></jsp:include>
<div style="margin: 15px;">
	<form class="layui-form" id="bannerForm">
		<input type="hidden" name="id">
		
		<div class="layui-form-item">
			<label class="layui-form-label">轮播名称</label>
			<div class="layui-input-inline">
				<input type="text" name="bannerName" autocomplete="off" class="layui-input" value="">
			</div>
			<label class="layui-form-label">轮播键</label>
			<div class="layui-input-inline">
				<input type="text" name="bannerKey" autocomplete="off" class="layui-input" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">轮播详细</label>
			<div class="layui-input-inline">
			
				<button class="layui-btn layui-btn-small" type="button" onclick="addBannerDetails()">
					<i class="layui-icon">添加</i>
				</button>
				<script type="text/javascript">
	                function addBannerDetails(){
	                	
	                	var index=0;
                		var bannerDetails=$("#bannerDetails").find("tr").length;
                		
                		if(bannerDetails>0){
                			index=index+bannerDetails;
                		}
                		
	                	var str='<tr>'+
		    				'<td><input type="checkbox" lay-skin="primary"></td>'+
		    				'<td><button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectBannerPicCallBack'+index+')">'+
		    				'<i class="layui-icon">上传图片</i>'+
		    				'</button><input type="hidden" name="bannerDetailsList['+index+'].image" required lay-verify="required" autocomplete="off" class="layui-input"  value=""><img width="100" height="100" name="cover_src_'+index+'" src="">'+
		    				'<script type="text/javascript">'+
		    				'function selectBannerPicCallBack'+index+'(fileUrlArr){'+
		    				'$("[name=\'cover_src_'+index+'\']").attr(\"src\",fileUrlArr[0]);'+
		    				'$("[name=\'bannerDetailsList['+index+'].image\']").val(fileUrlArr[0]);'+
		    				'}<\/script></td>'+
		    				'<td><input type="text" name="bannerDetailsList['+index+'].title" autocomplete="off" class="layui-input" value=""></td>'+
		    				'<td><input type="text" name="bannerDetailsList['+index+'].ref" autocomplete="off" class="layui-input" value=""></td>'+
		    				'<td><input type="text" name="bannerDetailsList['+index+'].sortNum" autocomplete="off" class="layui-input" value=""></td>'+
		    				'<td>'+
		    				'	<a onclick="remove(this)">删除</a>'+
		    				'</td>'+
	    				'</tr>';
	                	
	                	$("#bannerDetails").append(str);
	                	
	                }
	                
                
                </script>
	                
              
                
				
			</div>
			<div class="layui-field-box layui-form">
			<table class="layui-table admin-table">
			<thead>
			<tr>
				<th style="width: 30px;">
					<input type="checkbox" lay-filter="allselector" lay-skin="primary">
				</th>
				<th>
					封面
				</th>
				<th>
					标题
				</th>
				<th>
					跳转地址
				</th>
				<th>
					排序
				</th>
				<th>
					操作
				</th>
			</tr>
			</thead>
			<tbody id="bannerDetails">
			</tbody>
			</table>
		</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	function fillForm(obj){
		$("[name='id']").val(obj.id);
		$("[name='bannerName']").val(obj.bannerName);
		$("[name='bannerKey']").val(obj.bannerKey);
		var bannerDetailsList=obj.bannerDetailsList;
		for(var index=0;index<bannerDetailsList.length;index++){
			var str='<tr>'+
			'<td><input type="checkbox" lay-skin="primary"></td>'+
			'<td><button class="layui-btn layui-btn-small" type="button" onclick="openUpload(selectBannerPicCallBack'+index+')">'+
			'<i class="layui-icon">上传图片</i>'+
			'</button><input type="hidden" name="bannerDetailsList['+index+'].image" required lay-verify="required" autocomplete="off" class="layui-input"  value="'+bannerDetailsList[index].image+'"><img width="100" height="100" name="cover_src_'+index+'" src="'+bannerDetailsList[index].image+'">'+
			'<script type="text/javascript">'+
			'function selectBannerPicCallBack'+index+'(fileUrlArr){'+
			'$("[name=\'cover_src_'+index+'\']").attr(\"src\",fileUrlArr[0]);'+
			'$("[name=\'bannerDetailsList['+index+'].image\']").val(fileUrlArr[0]);'+
			'}<\/script></td>'+
			'<td><input type="text" name="bannerDetailsList['+index+'].title" autocomplete="off" class="layui-input" value="'+bannerDetailsList[index].title+'"></td>'+
			'<td><input type="text" name="bannerDetailsList['+index+'].ref" autocomplete="off" class="layui-input" value="'+bannerDetailsList[index].ref+'"></td>'+
			'<td><input type="text" name="bannerDetailsList['+index+'].sortNum" autocomplete="off" class="layui-input" value="'+bannerDetailsList[index].sortNum+'"></td>'+
			'<td>'+
			'	<a  onclick="remove(this)">删除</a>'+
			'</td>'+
		'</tr>';
    	
    	$("#bannerDetails").append(str);
		}

		 layui.use('form', function() {
				form.render();
			});
	

	}

</script>