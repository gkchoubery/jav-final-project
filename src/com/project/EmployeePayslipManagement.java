package com.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayslipManagement {

    private List<EmployeePayslip> employeePayslips;


    public EmployeePayslipManagement() {
        employeePayslips = new ArrayList<>();
    }

    public List<EmployeePayslip> getEmployeePayslips() {
        return employeePayslips;
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
            if (employeePayslip.getEmployee().getEmployeeType() == 'F') {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfNonFacultyProcessed() {
        int count = 0;
        for (EmployeePayslip employeePayslip : employeePayslips) {
            if (employeePayslip.getEmployee().getEmployeeType() == 'N') {
                count++;
            }
        }
        return count;
    }

    public EmployeePayslip generateNewEmployeePayslip(Scanner reader) throws InvalidChoiceException, InputMismatchException {
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
        if (employeeType == 'F' || employeeType == 'N') {
            employee = new Employee(ID, firstName, lastName, departmentName, employeeType);
        } else {
            throw new InvalidChoiceException("Employee type can only be a Faculty or a Non-Faculty");
        }

        // Declaring objects
        EmployeePayslip employeePayslip;

        if (employeeType == 'F') {
            System.out.print("Highest qualification degree (B/b/M/m): ");
            char degree = reader.nextLine().toUpperCase().charAt(0);
            if (degree == 'B' || degree == 'M') {

                employeePayslip = new FacultyPayslip(employee, totalHoursWorked, degree);
            } else {
                throw new InvalidChoiceException("Faculty can only have a Bachelors degree or Masters degree.");
            }
        } else {
            System.out.print("Monthly salary: ");
            double monthlySalary;
            try {
                monthlySalary = reader.nextDouble();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Invalid data provided. Only number values allowed.");
            }
            reader.nextLine();
            employeePayslip = new NonFacultyPayslip(employee, totalHoursWorked, monthlySalary);
        }

        return employeePayslip;
    }

}
