<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post">
        <label>Search Criteria</label>
        <input type="radio" name="searchCriteria" value="Employee" checked />Employee Search
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

    <br/>

    <c:choose>
        <c:when test="${not empty department}">
            <table border="2">
                <thead style="color: gray">
                    <tr>
                        <td>Id</td>
                        <td>Department Name</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${department.departmentId}" /></td>
                        <td><c:out value="${department.name}"/></td>
                    </tr>
                </tbody>
            </table>
        </c:when>
    </c:choose>

</body>
</html>