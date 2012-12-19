<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="get">
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

        <c:when test="${not empty employees}">
            <table border="2">
                <thead style="color: gray">
                <tr>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Title</td>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td><c:out value="${employee.firstName}" /></td>
                            <td><c:out value="${employee.lastName}"/></td>
                            <td><c:out value="${employee.lastName}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <c:if test="${currentPage != 1}">
                <td><a href="employee.do?page=${currentPage - 1}">Previous</a></td>
            </c:if>

            <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <td>${i}</td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="search?searchCriteria=${searchCriteria}&firstName=${firstName}&lastName=${lastName}&departmentName=${departmentName}&page=${i}">${i}</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>

            <c:if test="${currentPage lt noOfPages}">
                <td><a href="search?page=${currentPage + 1}">Next</a></td>
            </c:if>

        </c:when>
    </c:choose>

</body>
</html>