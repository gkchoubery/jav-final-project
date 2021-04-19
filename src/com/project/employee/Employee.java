package com.project.employee;

import com.project.utilities.Utils;

import java.util.Objects;

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

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getEmployeeType() {
        return employeeType;
    }

    public String getFullEmployeeType() {
        if (getEmployeeType() == 'F' || getEmployeeType() == 'f') return "Faculty";
        return "Non-Faculty";
    }

    public void setEmployeeType(char employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return Utils.getPaddedString(ID, Utils.ID) +
                Utils.getPaddedString(firstName + " " + lastName, Utils.FULL_NAME) +
                Utils.getPaddedString(getFullEmployeeType(), Utils.EMPLOYEE_TYPE);
    }
}
