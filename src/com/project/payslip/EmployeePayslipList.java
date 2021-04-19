package com.project.payslip;

import com.project.employee.FacultyEmployee;
import com.project.employee.NonFacultyEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayslipList {

    private List<EmployeePayslip> employeePayslips;

    public EmployeePayslipList() {
        employeePayslips = new ArrayList<>();
    }

    public boolean addEmployeePayslip(EmployeePayslip employeePayslip) {
        return this.employeePayslips.add(employeePayslip);
    }

    public List<EmployeePayslip> getEmployeePayslips() {
        return this.employeePayslips;
    }

    public int getNumberOfProcessedEmployees() {
        return this.employeePayslips.size();
    }

    public int getNumberOfFacultyProcessed() {
        int count = 0;
        for (EmployeePayslip employeePayslip : employeePayslips) {
            if (employeePayslip.getEmployee() instanceof FacultyEmployee) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfNonFacultyProcessed() {
        int count = 0;
        for (EmployeePayslip employeePayslip : employeePayslips) {
            if (employeePayslip.getEmployee() instanceof NonFacultyEmployee) {
                count++;
            }
        }
        return count;
    }

}
