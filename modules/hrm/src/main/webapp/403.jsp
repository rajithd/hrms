<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>Sorry , You are not authorized to access this page. Please logout.</h1>
  <h4><a href=<c:url value="/j_spring_security_logout"/>>Sign Out</a></h4>
</body>
</html>