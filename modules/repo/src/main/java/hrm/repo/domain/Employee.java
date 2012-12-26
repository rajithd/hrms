package hrm.repo.domain;


import hrm.repo.util.EmployeeState;
import hrm.repo.util.Gender;

import java.util.Date;

public class Employee {

    private long employeeNo;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String hireDate;
    private Title title;
    private Salary salary;
    private EmployeeDepartment employeeDepartment;
    private EmployeeState status;
    private String departmentSelect;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public EmployeeDepartment getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public EmployeeState getStatus() {
        return status;
    }

    public void setStatus(EmployeeState status) {
        this.status = status;
    }

    public String getDepartmentSelect() {
        return departmentSelect;
    }

    public void setDepartmentSelect(String departmentSelect) {
        this.departmentSelect = departmentSelect;
    }
}
