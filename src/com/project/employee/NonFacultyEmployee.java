package com.project.employee;


public class NonFacultyEmployee extends Employee {

    public NonFacultyEmployee() {
    }

    public NonFacultyEmployee(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department, 'N');
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
