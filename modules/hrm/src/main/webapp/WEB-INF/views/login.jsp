<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<h1>Login</h1>
<br/>

<form action="<c:url value="/j_spring_security_check" />" method="post">
    <label>Username</label>
    <input type="text" name="j_username" /> <br/>
    <label>Password</label>
    <input type="password" name="j_password"/>
    <input  type="submit" value="Login"/>

</form>
</body>
</html>