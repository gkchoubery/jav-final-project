package com.project;

public class Employee {

    protected String ID, firstName, lastName, department;
    protected char employeeType;

    public Employee() {
    }

    public Employee(String ID, String firstName, String lastName, String department, char employeeType) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employeeType = employeeType;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public char getEmployeeType() {
        return employeeType;
    }

    public String getFullEmployeeType() {
        if (getEmployeeType() == 'F' || getEmployeeType() == 'f') return "Faculty";
        return "Non-Faculty";
    }

    @Override
    public String toString() {
        return Utils.rightPad(Utils.rightPad("Employee Name: ",
                Utils.LEFT_HEADING_LENGTH) + getFullName(), Utils.LEFT_TEXT_LENGTH) +
                Utils.rightPad("Employee ID: ", 15) + getID() +
                "\n" +
                Utils.rightPad(Utils.rightPad("Department Name: ",
                        Utils.LEFT_HEADING_LENGTH) + getDepartment(), Utils.LEFT_TEXT_LENGTH) +
                Utils.rightPad("Employee Type: ", 15) + getFullEmployeeType() +
                "\n";
    }
}
