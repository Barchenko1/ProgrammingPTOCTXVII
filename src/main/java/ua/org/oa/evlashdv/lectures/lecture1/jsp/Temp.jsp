<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  ua.org.oa.evlashdv.lectures.lecture1.eeJspServletApp.var1.User: Администратор
  Date: 24.06.2018
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int i=5;%>
<%! private void doJob(){
    System.out.println("hello");
}%>
<%="hello world"%>
<%=new Date()%>
<%
    class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
%>
<%Student student=new Student();%>
<%student.setName("Pasha");%>
<%=student.getName()%>
</body>
</html>
