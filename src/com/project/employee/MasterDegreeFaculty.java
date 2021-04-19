package com.project.employee;

public class MasterDegreeFaculty extends FacultyEmployee {

    public MasterDegreeFaculty(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department);
    }

    @Override
    public char getDegree() {
        return 'M';
    }
}