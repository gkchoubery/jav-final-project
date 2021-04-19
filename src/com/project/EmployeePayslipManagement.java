package com.project;

import com.project.employee.*;
import com.project.exceptions.InvalidChoiceException;
import com.project.payslip.BachelorDegreeFacultyPayslip;
import com.project.payslip.EmployeePayslip;
import com.project.payslip.MasterDegreeFacultyPayslip;
import com.project.payslip.NonFacultyPayslip;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayslipManagement {

    private List<EmployeePayslip> employeePayslips;


    public EmployeePayslipManagement() {
        employeePayslips = new ArrayList<>();
    }

    public boolean addEmployeePayslip(EmployeePayslip employeePayslip) {
        return this.employeePayslips.add(employeePayslip);
    }

    public int getNumberOfProcessedPayslips() {
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

    public void processPayslips() {
        for (EmployeePayslip payslip :
                employeePayslips) {
            System.out.println(payslip);
        }
    }

    public EmployeePayslip generateNewEmployeePayslip(Scanner reader) throws InvalidChoiceException, InputMismatchException {
        EmployeePayslip employeePayslip;

        String ID, firstName, lastName, departmentName;
        double totalHoursWorked;
        char employeeType;

        System.out.println("Please enter the following details about the employee");
        System.out.print("Employee number: ");
        ID = reader.nextLine();
        System.out.print("Employee First Name: ");
        firstName = reader.nextLine();
        System.out.print("Employee Last Name: ");
        lastName = reader.nextLine();
        System.out.print("Employee Department Name: ");
        departmentName = reader.nextLine();
        System.out.print("Total hours worked in a month: ");
        try {
            totalHoursWorked = reader.nextDouble();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid data provided. Only number values allowed.");
        }
        reader.nextLine();
        System.out.print("Employee type - Faculty/Non-faculty (F/f/N/n): ");
        employeeType = reader.next().toUpperCase().charAt(0);
        reader.nextLine();

        Employee employee;

        if (employeeType == 'F') {
            System.out.print("Highest qualification degree (B/b/M/m): ");
            char degree = reader.nextLine().toUpperCase().charAt(0);
            if (degree == 'B') {
                employee = new BachelorDegreeFaculty(ID, firstName, lastName, departmentName);
                employeePayslip = new BachelorDegreeFacultyPayslip(employee, totalHoursWorked);
            } else if (degree == 'M') {
                employee = new MasterDegreeFaculty(ID, firstName, lastName, departmentName);
                employeePayslip = new MasterDegreeFacultyPayslip(employee, totalHoursWorked);
            } else {
                throw new InvalidChoiceException("Faculty can only have a Bachelors degree or Masters degree.");
            }


        } else if (employeeType == 'N') {
            System.out.print("Monthly salary: ");
            double monthlySalary;
            try {
                monthlySalary = reader.nextDouble();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Invalid data provided. Only number values allowed.");
            }
            reader.nextLine();
            employee = new NonFacultyEmployee(ID, firstName, lastName, departmentName);
            employeePayslip = new NonFacultyPayslip(employee, totalHoursWorked, monthlySalary);
        } else {
            throw new InvalidChoiceException("Employee type can only be a Faculty or a Non-Faculty");
        }
        return employeePayslip;
    }

}
