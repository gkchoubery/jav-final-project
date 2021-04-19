package com.project.employee;

import com.project.payslip.EmployeePayslip;

import java.util.Objects;

public class Employee {

    protected String ID, firstName, lastName, department;
    protected float hoursWorked;
    protected char employeeType;
    protected EmployeePayslip employeePayslip;

    public Employee() {
    }

    public Employee(String ID, String firstName, String lastName, String department, float hoursWorked, char employeeType) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.employeeType = employeeType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public char getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(char employeeType) {
        this.employeeType = employeeType;
    }

    public EmployeePayslip getEmployeePayslip() {
        return employeePayslip;
    }

    public void setEmployeePayslip(EmployeePayslip employeePayslip) {
        this.employeePayslip = employeePayslip;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", employeeType=" + employeeType +
                ", employeePayslip=" + employeePayslip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
