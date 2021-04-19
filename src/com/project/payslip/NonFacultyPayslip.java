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

    @Override
    public double getGrossSalary() {
        double hourlyRate = getHourlyRate();
        double grossSalary = 0;
        double remainingHours = totalHoursWorked;
        if (remainingHours > 160) {
            double overTime = remainingHours - 160;
            remainingHours -= overTime;
            grossSalary += overTime * hourlyRate * 2;
        }
        grossSalary += remainingHours * hourlyRate;
        return grossSalary;
    }
}
