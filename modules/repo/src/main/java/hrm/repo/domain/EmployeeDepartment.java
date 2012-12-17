package hrm.repo.domain;


import java.util.Date;

public class EmployeeDepartment {

    private long employeeNo;
    private long departmentNo;
    private String departmentFromDate;
    private String departmentToDate;

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public long getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(long departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getFromDate() {
        return departmentFromDate;
    }

    public void setFromDate(String fromDate) {
        this.departmentFromDate = fromDate;
    }

    public String getToDate() {
        return departmentToDate;
    }

    public void setToDate(String toDate) {
        this.departmentToDate = toDate;
    }
}
