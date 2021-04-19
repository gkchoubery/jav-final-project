package com.project.payslip;

import com.project.employee.Employee;

public class BachelorDegreeFacultyPayslip extends FacultyPayslip {

    public BachelorDegreeFacultyPayslip() {
    }

    public BachelorDegreeFacultyPayslip(Employee employee, double totalHoursWorked) {
        super(employee, totalHoursWorked);
    }

    @Override
    public double getHourlyRate() {
        return 100;
    }

    @Override
    public double getTeachingAllowance() {
        return 600;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
