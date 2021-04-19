package com.project.payslip;

import com.project.employee.Employee;
import com.project.utilities.Utils;

public abstract class EmployeePayslip {

    private Employee employee;
    protected double totalHoursWorked;

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

    public double getHealthSurchargeFee() {
        if (getGrossSalary() > 3000) {
            return 33;
        } else {
            return 19.20;
        }
    }

    public double getIncomeTaxAmount() {
        if (getGrossSalary() < 2500) return 0;
        return (getGrossSalary() - 2500) * 0.25;

    }

    public abstract double getHourlyRate();

    public abstract double getGrossSalary();

    public double getNetSalary() {
        return getGrossSalary() - getIncomeTaxAmount() - getHealthSurchargeFee();
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
