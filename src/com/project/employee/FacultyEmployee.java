package com.project.employee;

public abstract class FacultyEmployee extends Employee {

    public FacultyEmployee() {
    }

    public FacultyEmployee(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department, 'F');
    }

    public abstract char getDegree();
}
