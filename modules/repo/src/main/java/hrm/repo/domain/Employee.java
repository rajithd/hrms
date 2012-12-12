package hrm.repo.domain;


import hrm.repo.util.Gender;

import java.util.Date;

public class Employee {

    private long employeeNo;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private Date hireDate;
    private String startingJobTitle;
    private Date fromStartingJobTitleDate;
    private Date toStartingJobTitleDate;
    private Double salary;
    private Date fromStartingSalaryDate;
    private Date toStartingSalaryDate;
    private String departmentName;
    private Date fromDepartmentDate;
    private Date toDepartmentDate;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getStartingJobTitle() {
        return startingJobTitle;
    }

    public void setStartingJobTitle(String startingJobTitle) {
        this.startingJobTitle = startingJobTitle;
    }

    public Date getFromStartingJobTitleDate() {
        return fromStartingJobTitleDate;
    }

    public void setFromStartingJobTitleDate(Date fromStartingJobTitleDate) {
        this.fromStartingJobTitleDate = fromStartingJobTitleDate;
    }

    public Date getToStartingJobTitleDate() {
        return toStartingJobTitleDate;
    }

    public void setToStartingJobTitleDate(Date toStartingJobTitleDate) {
        this.toStartingJobTitleDate = toStartingJobTitleDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getFromStartingSalaryDate() {
        return fromStartingSalaryDate;
    }

    public void setFromStartingSalaryDate(Date fromStartingSalaryDate) {
        this.fromStartingSalaryDate = fromStartingSalaryDate;
    }

    public Date getToStartingSalaryDate() {
        return toStartingSalaryDate;
    }

    public void setToStartingSalaryDate(Date toStartingSalaryDate) {
        this.toStartingSalaryDate = toStartingSalaryDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getFromDepartmentDate() {
        return fromDepartmentDate;
    }

    public void setFromDepartmentDate(Date fromDepartmentDate) {
        this.fromDepartmentDate = fromDepartmentDate;
    }

    public Date getToDepartmentDate() {
        return toDepartmentDate;
    }

    public void setToDepartmentDate(Date toDepartmentDate) {
        this.toDepartmentDate = toDepartmentDate;
    }
}
