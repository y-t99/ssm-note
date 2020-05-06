<%--
  Created by IntelliJ IDEA.
  User: 13727
  Date: 2020/4/25
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/app/form/convenient" method="post"
          enctype="multipart/form-data">
        <input type="file" name="file">
        <input name="name">
        <input type="submit" value="submit">
    </form>
</body>
</html>
