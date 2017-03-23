<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/lib/crypto1/crypto/crypto.js"></script>
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/lib/crypto1/hmac/hmac.js"></script>
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/lib/crypto1/sha1/sha1.js"></script>
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/lib/base64.js"></script>
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/lib/plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="/resource/plugins/oss-h5-upload-js-direct/upload.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
    
    	popUploadPlugin();

    });
    function getFileUrlArr(){

    	return this.fileUrlArr;
    }
</script>

<div id="uploadDialog" >
	<h4>您所选择的文件列表：${param.target_img }</h4>
	<div id="container">
		<a id="fileUpload_selectfiles" href="javascript:void(0);" class='btn'>选择文件</a>
		<a id="fileUpload_postfiles" href="javascript:void(0);" class='btn'>开始上传</a>
	</div>
	<div id="fileUpload_ossfile">你的浏览器不支持flash,Silverlight或者HTML5！</div>
	<br/>
	<pre id="fileUpload_console"></pre>
</div>










