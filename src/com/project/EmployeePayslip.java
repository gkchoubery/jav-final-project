package com.project;

public abstract class EmployeePayslip implements IEndOfFunction {

    private Employee employee;
    protected double totalHoursWorked;
    protected static final double FULL_TIME_HOURS = 160;
    protected static final double TAX_FREE_ALLOWANCE = 2500;

    public EmployeePayslip() {
    }

    public EmployeePayslip(Employee employee, double totalHoursWorked) {
        this.employee = employee;
        this.totalHoursWorked = totalHoursWorked;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getHealthSurchargeFee() {
        if (getGrossSalary() > 3000) {
            return 33;
        } else {
            return 19.20;
        }
    }

    public double getIncomeTaxAmount() {
        if (getGrossSalary() < TAX_FREE_ALLOWANCE) return 0;
        return (getGrossSalary() - TAX_FREE_ALLOWANCE) * 0.25;

    }

    public double getDeductions() {
        return getIncomeTaxAmount() + getHealthSurchargeFee();
    }

    public double getNetSalary() {
        return getGrossSalary() - getDeductions();
    }

    public abstract double getHourlyRate();

    public abstract double getGrossSalary();

    @Override
    public String toString() {
        return Utils.centerPad("Start of Employee payslip", 50, '-') +
                "\n" +
                employee.toString() +
                Utils.centerPad("Payslip Information", 50, '-') +
                "\n" +
                Utils.rightPad("Hourly rate: ", Utils.LEFT_HEADING_LENGTH) + "$" + getHourlyRate() +
                "\n" +
                Utils.rightPad("Total hours worked: ", Utils.LEFT_HEADING_LENGTH) + totalHoursWorked +
                "\n" +
                Utils.rightPad("Gross Salary: ", Utils.LEFT_HEADING_LENGTH) + "$" + getGrossSalary() +
                "\n" +
                Utils.rightPad("Income Tax Deduction: ", Utils.LEFT_HEADING_LENGTH) + "$" + getIncomeTaxAmount() +
                "\n" +
                Utils.rightPad("Health Surcharge Fee: ", Utils.LEFT_HEADING_LENGTH) + "$" + getHealthSurchargeFee() +
                "\n" +
                Utils.rightPad("Net Income: ", Utils.LEFT_HEADING_LENGTH) + "$" + getNetSalary() +
                "\n";
    }

    @Override
    public String outputString() {
        return Utils.centerPad("End of Employee Payslip", 50, '-') + "\n";
    }
}
