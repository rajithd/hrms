<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<form method="post">

    <sec:authorize ifAnyGranted="ROLE_ADMIN_LOGIN,ROLE_HR_LOGIN">
        <label>Employee No</label>
        <input type="text" name="employeeNo"/>
        <c:if test="${empNoEmpty}">
            <label style="color: red">Please enter employee No</label>
        </c:if>
        <br/>
        <br/>
    </sec:authorize>

    <label>Current Password</label>
    <input type="text" name="currentPassword"/> <br/>
    <label>New Password</label>
    <input type="text" name="newPassword"/> <br/>
    <label>Confirm Password</label>
    <input type="text" name="confirmPassword"/> <br/>
    <br/>
    <input type="submit" value="Save"/>

</form>
</body>
</html>