<%--
  Created by IntelliJ IDEA.
  User: Rajith
  Date: 12/18/12
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post">
        <label>Search Criteria</label>
        <input type="radio" name="searchCriteria" value="Employee" />Employee Search
        <input type="radio" name="searchCriteria" value="Department" />Dept Search
        <br/>
        <br/>
        <label>Employee details</label>
        <br/>
        <input type="text" name="firstName" /> <br/>
        <input type="text" name="lastName" />

        <br/>
        <br/>

        <label>Department Details</label>     <br/>
        <input type="text" name="departmentName" />
        <br/> <br/>
        <input type="submit" value="Search" />

    </form>
</body>
</html>