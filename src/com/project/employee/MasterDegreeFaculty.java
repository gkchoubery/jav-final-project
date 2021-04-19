package com.project.employee;

public class MasterDegreeFaculty extends FacultyEmployee {

    public MasterDegreeFaculty() {
    }

    public MasterDegreeFaculty(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department);
    }

    @Override
    public char getDegree() {
        return 'M';
    }

    @Override
    public String toString() {
        return super.toString();
    }
}