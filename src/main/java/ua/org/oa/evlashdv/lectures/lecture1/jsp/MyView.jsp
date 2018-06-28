<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 25.06.2018
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="Student" class="jsp.Student" scope="request"/>
<%--<jsp:useBean id="Student" class="jsp.Student" scope="session"/>--%>
<%--<jsp:useBean id="Student" class="jsp.Student" scope="application"/>--%>
<jsp:getProperty name="Student" property="name"/>
</body>
</html>
