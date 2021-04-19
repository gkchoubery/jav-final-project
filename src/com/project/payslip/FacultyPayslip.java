package com.project.payslip;

import com.project.employee.Employee;

public abstract class FacultyPayslip extends EmployeePayslip {

    public FacultyPayslip() {
    }

    public FacultyPayslip(Employee employee, double totalHoursWorked) {
        super(employee, totalHoursWorked);
    }

    public abstract double getTeachingAllowance();

    @Override
    public double getGrossSalary() {
        return (getHourlyRate() * totalHoursWorked) + getTeachingAllowance();
    }
}
