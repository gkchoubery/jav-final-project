package com.project.employee;

import com.project.payslip.EmployeePayslip;
import com.project.payslip.FacultyPayslip;

public class FacultyEmployee extends Employee {

    public FacultyEmployee(String ID, String firstName, String lastName, String department, float hoursWorked) {
        super(ID, firstName, lastName, department, hoursWorked, 'F');
        EmployeePayslip payslip = new FacultyPayslip();
        setEmployeePayslip(payslip);
    }
}
