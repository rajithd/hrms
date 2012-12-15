<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h3>Welcome <c:out value="${username}" /> </h3>
    <jsp:include page="common/header.jsp"/>
</body>
</html>