<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post">
        <label>Employee No</label>
        <input type="text" name="empNo" />
        <c:if test="${emptyEmployee}">
            <label style="color: red">Cannot find Employee</label>
        </c:if>
        <br/>
        <label>Change State to</label>
        <select name="stateSelect">
            <c:forEach items="${stateList}" var="state">
                <option value="<c:out value="${state}"/>"
                selected="selected">${state}
                </option>
            </c:forEach>
        </select>
        <br/>
        <input type="submit" value="Submit" />

    </form>
</body>
</html>