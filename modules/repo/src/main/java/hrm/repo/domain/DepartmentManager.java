package hrm.repo.domain;


public class DepartmentManager {
    private long departmentNo;
    private long employeeNo;
    private String fromDate;
    private String toDate;

    public long getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(long departmentNo) {
        this.departmentNo = departmentNo;
    }

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
