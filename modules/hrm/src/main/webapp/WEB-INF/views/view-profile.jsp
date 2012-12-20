<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
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
</form>
<sec:authorize ifAnyGranted="ROLE_USER_LOGIN">
    <label>Employee No</label>
    <input type="text" value="<c:out value="${empNo}" />" disabled="disabled"/>
    <br/>
    <label>First Name</label>
    <input type="text" value="<c:out value="${employee.firstName}" />" disabled="disabled"/>
    <br/>
    <label>Last Name</label>
    <input type="text" value="<c:out value="${employee.lastName}" />" disabled="disabled"/>
    <br/>
    <label>Date of Birth</label>
    <input type="text" value="<c:out value="${employee.dateOfBirth}" />" disabled="disabled"/>
    <br/>
    <label>Gender</label>
    <input type="text" value="<c:out value="${employee.gender}" />" disabled="disabled"/>
    <br/>
    <label>Hire Date</label>
    <input type="text" value="<c:out value="${employee.hireDate}" />" disabled="disabled"/>
    <br/>
    <label>Job Title</label>
    <input type="text" value="<c:out value="${title.titleName}" />" disabled="disabled"/>
    <br/>
    <label>From Date</label>
    <input type="text" value="<c:out value="${title.fromDate}" />" disabled="disabled"/>
    <br/>
    <label>To Date</label>
    <input type="text" value="<c:out value="${title.toDate}" />" disabled="disabled"/>
    <br/>
    <label>Salary</label>
    <input type="text" value="<c:out value="${salary.amount}" />" disabled="disabled"/>
    <br/>
    <label>From Date</label>
    <input type="text" value="<c:out value="${salary.fromDate}" />" disabled="disabled"/>
    <br/>
    <label>To Date</label>
    <input type="text" value="<c:out value="${salary.toDate}" />" disabled="disabled"/>
    <br/>
</sec:authorize>


</body>
</html>