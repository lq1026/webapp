<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
  <head>
    
    <title>带进度条文件上传效果</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style type="text/css">
        #progressBar{width: 300px;height: 20px;border: 1px #EEE solid;}
        #progress{width: 0%;height: 20px;background-color: lime;}
    </style>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript">
    $(function(){
    	 $('#progressBar').hide();
    	 $('#file').click(
    	       function (){
    	    		 $('#progressBar').hide();   
    	    		 $("#proInfo").text("");
    	       }
    	 )
    	 
    	
    })
    
   
        function upload(){
    	 $('#progressBar').show();
            $("#f1").submit();
            var pro=null;
            pro=setInterval(function(){
                $.get("FileUpServlet","",function(data){
                    if(data=='100%'){
                        clearInterval(pro);
                        $("#proInfo").text("上传进度：100%");
                         //更新进度条
                        $("#progress").width("100%");
                    }else{//正在上传
                        //更新进度信息
                        $("#proInfo").text("上传进度："+data);
                        //更新进度条
                        $("#progress").width(data);
                    }
                });
            },200);
        }
        
    </script>
  </head>
  
  <body>
      <iframe name="aa" style="display: none;"></iframe>
    <h2>带进度条上传效果</h2>
    <form target="aa" id="f1" action="FileUpServlet" method="post" enctype="multipart/form-data">
      文件：<input id="file" name="file" type="file">
        <input type="button" value="上传" onclick="upload();">
        <div id="progressBar">
            <div id="progress"></div>
        </div>
        <span id="proInfo"></span>
    </form>
  </body>
</html>