package com.project.payslip;

import com.project.employee.Employee;

public class MasterDegreeFacultyPayslip extends FacultyPayslip {

    public MasterDegreeFacultyPayslip(Employee employee, double totalHoursWorked) {
        super(employee, totalHoursWorked);
    }

    @Override
    public double getHourlyRate() {
        return 175;
    }

    @Override
    public double getTeachingAllowance() {
        return 1500;
    }
}
