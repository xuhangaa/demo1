<%--
  Created by IntelliJ IDEA.
  User: xh
  Date: 2021/8/17
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <input type="text" name="userList[0].name"> <br>
        <input type="text" name="userList[0].age"> <br>
        <input type="text" name="userList[1].name"> <br>
        <input type="text" name="userList[1].age"> <br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
