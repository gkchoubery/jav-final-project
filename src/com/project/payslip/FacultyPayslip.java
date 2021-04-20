package com.project.payslip;

import com.project.employee.Employee;
import com.project.utilities.Utils;

public class FacultyPayslip extends EmployeePayslip {

    private char highestQualification;

    public FacultyPayslip() {
    }

    public FacultyPayslip(Employee employee, double totalHoursWorked, char highestQualification) {
        super(employee, totalHoursWorked);
        this.highestQualification = highestQualification;
    }

    private double getTeachingAllowance() {
        if (highestQualification == 'B') return 600;
        return 1500;
    }

    public String getFullHighestQualification() {
        if (highestQualification == 'B') return "Bachelors Degree";
        return "Masters Degree";
    }

    @Override
    public double getHourlyRate() {
        if (highestQualification == 'B') return 100;
        return 175;
    }

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
                Utils.rightPad("Highest Qualification: ", Utils.LEFT_HEADING_LENGTH) + getFullHighestQualification() +
                "\n" +
                "\n\n\n";
    }
}
