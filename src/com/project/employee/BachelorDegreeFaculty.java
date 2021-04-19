package com.project.employee;

public class BachelorDegreeFaculty extends FacultyEmployee {

    public BachelorDegreeFaculty(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department);
    }

    @Override
    public char getDegree() {
        return 'B';
    }
}
