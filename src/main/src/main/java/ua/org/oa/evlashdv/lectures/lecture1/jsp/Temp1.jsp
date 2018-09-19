<%--
  Created by IntelliJ IDEA.
  ua.org.oa.evlashdv.lectures.lecture1.eeJspServletApp.var1.User: Администратор
  Date: 24.06.2018
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getMethod()%>
<%=response.setStatus(HttpServletResponse.SC_OK)%>
<%=session.getAttribute("one")%>
<%=application%>
<%=config%>
</body>
</html>
