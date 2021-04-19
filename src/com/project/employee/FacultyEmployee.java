package com.project.employee;

import com.project.utilities.Utils;

public abstract class FacultyEmployee extends Employee {

    public FacultyEmployee() {
    }

    public FacultyEmployee(String ID, String firstName, String lastName, String department) {
        super(ID, firstName, lastName, department, 'F');
    }

    public abstract char getDegree();

    public String getFullDegree() {
        if (getDegree() == 'B') return "Bachelors Degree";
        return "Masters Degree";
    }

    @Override
    public String toString() {
        return super.toString() +
                Utils.rightPad(Utils.rightPad("Highest qualification: ",
                        Utils.LEFT_HEADING_LENGTH) + getFullDegree(), Utils.LEFT_TEXT_LENGTH) +
                "\n";
    }
}
