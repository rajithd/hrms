<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post">
    <label>Personal Details</label>
    <br/>
    <label>First Name</label>
    <input type="text" name="firstName"/> <br/>
    <label>Last Name</label>
    <input type="text" name="lastName"/> <br/>
    <label>Date of Birth (seperate with /)</label>
    <input type="text" name="dateOfBirth"/> <br/>
    <label>Gender</label>
    <input type="radio" name="gender" value="M"/> Male
    <input type="radio" name="gender" value="F"/> Female
    <br/>

    <label>Hire date</label>
    <input type="text" name="hireDate"/> <br/>

    <br/>
    <label>Starting Job Title</label>
    <input type="text" name="titleName"/> <br/>
    <label>From</label>
    <input type="text" name="fromDate"/> <br/>
    <label>To</label>
    <input type="text" name="toDate"/> <br/>

    <br/>
    <label>Starting salary</label>
    <input type="text" name="amount"/> <br/>
    <label>From</label>
    <input type="text" name="salaryFromDate"/> <br/>
    <label>To</label>
    <input type="text" name="salaryToDate"/> <br/>

    <br/>
    <label>Department</label>
    <select name="departmentSelect">
        <c:forEach items="${depList}" var="dep">
            <option value="<c:out value="${dep.departmentId}"/>"
                    selected="selected">${dep.name}
            </option>
        </c:forEach>
    </select> <br/>

    <label>From</label>
    <input type="text" name="departmentFromDate"/> <br/>
    <label>To</label>
    <input type="text" name="departmentToDate"/> <br/>

    <br/>
    <input type="submit" value="submit" />


</form>
</body>
</html>