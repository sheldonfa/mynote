<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>欢迎来到管理后台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="upload/" enctype="multipart/form-data" method="post">
    <h1>导入数据</h1>
    <table>
        <tr>
            <td>
                <label for="file">请选择csv文件</label>
            </td>
            <td><input id="file" type="file" name="file"></td>
        </tr>
        <tr>
            <td>
                <input type="submit">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
