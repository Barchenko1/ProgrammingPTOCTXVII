<%@ page import="jsp.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="person" class="jsp.Person"/>

<jsp:setProperty name="person" property="name" value="Max"/>

<jsp:getProperty name="person" property="name"/>

</body>
</html>
