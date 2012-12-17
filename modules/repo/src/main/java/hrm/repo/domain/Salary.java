package hrm.repo.domain;


import java.util.Date;

public class Salary {

    private long employeeNo;
    private String amount;
    private String salaryFromDate;
    private String salaryToDate;

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFromDate() {
        return salaryFromDate;
    }

    public void setFromDate(String fromDate) {
        this.salaryFromDate = fromDate;
    }

    public String getToDate() {
        return salaryToDate;
    }

    public void setToDate(String toDate) {
        this.salaryToDate = toDate;
    }
}
