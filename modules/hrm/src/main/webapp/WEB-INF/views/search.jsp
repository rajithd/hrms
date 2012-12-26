<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
    <form method="get">

        <c:if test="${regex}">
            <label style="color: red">Please check your input. Only accepting Alpha</label>
        </c:if>
        <br/>
        <label>Search</label>
        <br/>
        <label>Employee Last Name</label>
        <input type="text" name="lastName" />
        <br/>
        <label>Department</label>
        <input type="text" name="departmentName" />
        <br/>
        <label>Title</label>
        <input type="text" name="title"/>

        <br/>
        <br/>
        <input type="submit" value="Search" />

    </form>

    <br/>

    <c:choose>
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
                            <td><c:out value="${employee.lastName}"/></td>
                            <td><c:out value="${employee.title.titleName}"/></td>
                            <td><c:out value="${employee.department.name}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <c:if test="${currentPage != 1}">
                <td><a href="search?lastName=${lastName}&departmentName=${departmentName}&title=${title}&page=${currentPage - 1}">Previous</a></td>
            </c:if>

            <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <td>${i}</td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="search?lastName=${lastName}&departmentName=${departmentName}&title=${title}&page=${i}">${i}</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>

            <c:if test="${currentPage lt noOfPages}">
                <td><a href="search?lastName=${lastName}&departmentName=${departmentName}&title=${title}&page=${currentPage + 1}">Next</a></td>
            </c:if>

        </c:when>
    </c:choose>

</body>
</html>