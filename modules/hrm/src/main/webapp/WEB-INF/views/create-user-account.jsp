<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post">
        <label>Employee No</label>
        <input type="text" name="employeeNo"/> <br/>

        <br/>
        <label>User Name</label>
        <input type="text" name="username"/> <br/>
        <label>Password</label>
        <input type="text" name="password"/> <br/>
        <label>Authority</label>
        <select name="level">
            <c:forEach items="${levels}" var="level">
                <option value="<c:out value="${level}"/>"
                        selected="selected">${level}
                </option>
            </c:forEach>
        </select> <br/>

        <br/>
        <input type="submit" value="Create Account" />



    </form>
</body>
</html>