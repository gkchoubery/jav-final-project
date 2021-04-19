package com.project.payslip;

import com.project.employee.Employee;

public class NonFacultyPayslip extends EmployeePayslip {

    private double monthlySalary;

    public NonFacultyPayslip() {
    }

    public NonFacultyPayslip(Employee employee, double totalHoursWorked, double monthlySalary) {
        super(employee, totalHoursWorked);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getHourlyRate() {
        return this.monthlySalary / 160.00;
    }
}
