package com.project.employee;


public class NonFacultyEmployee extends Employee {

    public NonFacultyEmployee(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department, 'N');
    }
}
