<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Up Down</title>
</head>
<body> 

      <form method="post"  action="/QXFileSys/FileUpServlet" enctype="multipart/form-data"> 
      选择一个文件：<br><br>
      <div style="border:1px solid #000;">
        <input type="file" name="singleUploadFile">
      <input type="submit" value="上传">
      </div>
    
      </form>
         
         
      <form method="post"  action="/QXFileSys/FileUpServlet" enctype="multipart/form-data"> 
      选择多个文件：<br><br>
      <div style="border:1px solid #000;">
        <input type="file" name="singleUploadFile1"><br>
         <input type="file" name="singleUploadFile2"><br>
          <input type="file" name="singleUploadFile3"><br>
           <input type="file" name="singleUploadFile4"><br>
      <input type="submit" value="上传">
      </div>
    
      </form>
</body>
</html>