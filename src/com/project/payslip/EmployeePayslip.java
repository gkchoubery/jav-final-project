package com.project.payslip;

import com.project.employee.Employee;

public abstract class EmployeePayslip {

    private Employee employee;
    private double totalHoursWorked;

    public EmployeePayslip() {
    }

    public EmployeePayslip(Employee employee, double totalHoursWorked) {
        this.employee = employee;
        this.totalHoursWorked = totalHoursWorked;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public abstract double getHourlyRate();

}
