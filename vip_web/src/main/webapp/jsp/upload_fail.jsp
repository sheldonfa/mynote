<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>欢迎来到管理后台</title>
    <style>
        p {
            color: #ff0000;
        }
    </style>
</head>
<body>
<form action="/upload_jsp" method="post" enctype="multipart/form-data">
    <h1>上传失败，错误原因如下：</h1><br>
    <p>${reason}</p>
</form>
</body>
</html>
