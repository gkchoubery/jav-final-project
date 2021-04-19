package com.project.employee;


import com.project.payslip.EmployeePayslip;
import com.project.payslip.NonFacultyPayslip;

public class NonFacultyEmployee extends Employee {

    public NonFacultyEmployee(String ID, String firstName, String lastName, String department, float hoursWorked) {
        super(ID, firstName, lastName, department, hoursWorked, 'N');
        EmployeePayslip payslip = new NonFacultyPayslip();
        setEmployeePayslip(payslip);
    }
}
