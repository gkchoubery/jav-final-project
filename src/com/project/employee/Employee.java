package com.project.employee;

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

    public void setEmployeeType(char employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID.equals(employee.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
