
var uploader;
var accessid= 'PRL6HiBHjcZbZA98';
var accesskey= 'WeHnggGKg6SAvljlUhCXprPQ1cY32u';
var host = 'http://img.u-workshop.com';
var imgHost = 'http://img.u-workshop.com/';
var fileUrlArr;
var g_dirname = 'project/';
var now = timestamp = Date.parse(new Date()) / 1000; 

var policyText = {
    "expiration": "2020-01-01T12:00:00.000Z", //设置该Policy的失效时间，超过这个失效时间之后，就没有办法通过这个policy上传文件了
    "conditions": [
    ["content-length-range", 0, 1048576000] // 设置上传文件的大小限制
    ]
};

var policyBase64 = Base64.encode(JSON.stringify(policyText));
var message = policyBase64;
var bytes = Crypto.HMAC(Crypto.SHA1, message, accesskey, { asBytes: true }) ;
var signature = Crypto.util.bytesToBase64(bytes);



//回调函数携带参数：上传文件的地址列表  eg:["www.1.com/1.jpg","www.1.com/2.jpg"]
function popUploadPlugin(callback,param1,param2){
	
	
	uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'fileUpload_selectfiles', 
	    //multi_selection: false,
		container: document.getElementById('container'),
		flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
		silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
	    url : 'http://oss.aliyuncs.com',
	    filters:{
	    	max_file_size:"1024kb"
	    },
		init: {
			PostInit: function() {
				$("#fileUpload_console").html("");
				document.getElementById('fileUpload_ossfile').innerHTML = '';
				document.getElementById('fileUpload_postfiles').onclick = function() {
	            set_upload_param(uploader, '', false);
	            return false;
				};
			},

			FilesAdded: function(up, files) {
				
				
				var exceedLimit = false;
				plupload.each(files, function(file) {
					
				document.getElementById('fileUpload_ossfile').innerHTML 
				+= '<div id="' + file.id + '">' + file.name + ' (' 
				+ plupload.formatSize(file.size) + ') <a id="removeSelectFile-'+file.id+'" href="javascript:;" onclick="removeSelectFile(this,\''+file.id+'\')">删除</a><b></b>'
				+'<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
				+'</div>';
					
				});
			},

			BeforeUpload: function(up, file) {
				
				
				var _suffix = get_suffix(file.name);
				file.name= g_dirname + random_string(10) + _suffix ;
				
	            set_upload_param(up, file.name, true);
	        },

			UploadProgress: function(up, file) {
				var d = document.getElementById(file.id);
				d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	            var prog = d.getElementsByTagName('div')[0];
				var progBar = prog.getElementsByTagName('div')[0]
				progBar.style.width= 2*file.percent+'px';
				progBar.setAttribute('aria-valuenow', file.percent);
			},

			FileUploaded: function(up, file, info) {
	            if (info.status == 200)
	            {
	                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<a >' + imgHost+'/'+file.name+'</a>';
	                $("#removeSelectFile-"+file.id).remove();
	            }
	            else
	            {
	                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
	            } 
			},
			UploadComplete:function(uploader,files){
				fileUrlArr = new Array();
				plupload.each(files, function(file) {
					var fileUrl = imgHost+"/"+file.name;
					fileUrlArr.push(fileUrl);
				});
				uploader.splice(0, files.length);//上传完毕之后，移除队列中的所有文件，便于下一次上传
				/*alert("9"+$("#avatar_img",window.parent.document).attr("src"));
				$("#avatar_img",window.parent.document).attr("src",fileUrlArr[0]+"@100h");
				alert("9"+$("#avatar_img",window.parent.document).attr("src"));
				if(callback){
					callback(fileUrlArr,param1,param2);
					
				}else{
					console.error("缺少回调函数");
				}*/
				
			},
			Error: function(up, err) {
				$("#fileUpload_console").html(err.message);
			}
		}
	});
	uploader.init();
	
	/*$('#uploadDialog').dialog({
	    title: '文件上传控件（单个文件最大1M）',
	    width: "50%",
	    closed: false,
	    cache: false,
	    modal: true,
	    onClose:function(){
	    	document.getElementById('fileUpload_ossfile').innerHTML = '';
	    	
	    	uploader.destroy();
	    }
	});*/
	
	/*width = 700;
	height = 400;
	if(width=="100%" || height=="100%"){
		width = window.top.document.body.offsetWidth;
		height =window.top.document.body.offsetHeight-100;
	}
	
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: "url:"+'webpage/plugin/uploadFilePlugin.jsp',
			zIndex: getzIndex(),
			lock : true,
			width:width,
			height: height,
			title:'文件上传控件（单个文件最大1M）',
			opacity : 0.3,
			cache:false, 
		    cancelVal: '关闭',
		    cancel: true 
		});
	}else{
		W.$.dialog({
			content: "url:"+'webpage/plugin/uploadFilePlugin.jsp',
			zIndex: getzIndex(),
			lock : true,
			width:width,
			height: height,
			parent:windowapi,
			title:'文件上传控件（单个文件最大1M）',
			opacity : 0.3,
			cache:false, 
		    cancelVal: '关闭',
		    cancel: true
		});
	}*/
	
}


function random_string(len) {
	var len = len || 32;
	var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';   
	var maxPos = chars.length;
	var pwd = '';
	for (i = 0; i < len; i++) {
		pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function get_suffix(filename) {
    var pos = filename.lastIndexOf('.');
    var suffix = '';
    if (pos != -1) {
        suffix = filename.substring(pos);
    }
    return suffix;
}


function set_upload_param(up, filename, ret)
{
    new_multipart_params = {
        'key' : filename,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid, 
        'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
        'signature': signature,
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });

    up.start();
}


function removeSelectFile(obj,fileId){
	$(obj).parent().remove();
	uploader.removeFile(fileId);
	
}
