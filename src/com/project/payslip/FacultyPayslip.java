package com.project.payslip;

import com.project.employee.Employee;
import com.project.utilities.Utils;

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

    @Override
    public String toString() {
        return super.toString() +
                Utils.centerPad("Extras", 50, '+') +
                "\n" +
                Utils.rightPad("Teaching Allowance: ", Utils.LEFT_HEADING_LENGTH) + "$" + getTeachingAllowance() +
                "\n" +
                "\n\n\n";
    }
}
