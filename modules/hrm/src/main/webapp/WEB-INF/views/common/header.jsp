<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<sec:authorize ifAnyGranted="ROLE_CREATE_DEPARTMENT">
    <a href="create-department">Create Department</a>

</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_CREATE_USER_ACCOUNT">
    <a href="create-account">Create User Account</a>
</sec:authorize>

<sec:authorize  ifAnyGranted="ROLE_CREATE_PROFILE">
<a href="create-employee">Create User Profile</a>
</sec:authorize>

<a href="view-profile">View User Profile</a>
<a href="change-password">Change Password</a>
<a href="search">Search</a>

<a href=<c:url value="/j_spring_security_logout"/>>Sign Out</a>

</body>
</html>