<%--
  Created by IntelliJ IDEA.
  User: Rajith
  Date: 12/17/12
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
    <form method="post">
        <label>Department Details</label>
        <br/>
        <label>Dept Name</label>
        <input type="text" name="name" /> <br/>

        <label>Dept manager details</label> <br/>
        <label>Emp No</label>
        <input type="text" name="employeeNo" /> <br/>
        <label>From Date</label>
        <input type="text" name="fromDate" /> <br/>
        <label>To Date</label>
        <input type="text" name="toDate" /> <br/>
        <br/>
        <input type="submit" value="Create Department" /> <br/>

    </form>
</body>
</html>