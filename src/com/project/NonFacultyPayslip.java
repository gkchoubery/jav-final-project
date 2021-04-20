package com.project;

public class NonFacultyPayslip extends EmployeePayslip {

    private double monthlySalary;

    public NonFacultyPayslip() {
    }

    public NonFacultyPayslip(Employee employee, double totalHoursWorked, double monthlySalary) {
        super(employee, totalHoursWorked);
        this.monthlySalary = monthlySalary;
    }

    public double getOverTime() {
        if (totalHoursWorked > FULL_TIME_HOURS) {
            return totalHoursWorked - FULL_TIME_HOURS;
        }
        return 0;
    }

    @Override
    public double getHourlyRate() {
        return this.monthlySalary / FULL_TIME_HOURS;
    }

    @Override
    public double getGrossSalary() {
        double hourlyRate = getHourlyRate();
        double grossSalary = 0;
        double remainingHours = totalHoursWorked;
        if (getOverTime() > 0) {
            grossSalary += getOverTime() * hourlyRate * 2;
            remainingHours -= getOverTime();
        }
        grossSalary += remainingHours * hourlyRate;
        return grossSalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                Utils.centerPad("Extras", 50, '+') +
                "\n" +
                Utils.rightPad("Monthly Salary: ", Utils.LEFT_HEADING_LENGTH) + "$" + monthlySalary +
                "\n" +
                (getOverTime() > 0 ? Utils.rightPad("Over time: ", Utils.LEFT_HEADING_LENGTH) + getOverTime() + "hours" +
                        "\n\n" : "\n") +
                outputString() +
                "\n\n";
    }
}
