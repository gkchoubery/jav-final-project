package com.project;

import com.project.employee.BachelorDegreeFaculty;
import com.project.employee.Employee;
import com.project.employee.MasterDegreeFaculty;
import com.project.employee.NonFacultyEmployee;
import com.project.exceptions.InvalidChoiceException;
import com.project.payslip.BachelorDegreeFacultyPayslip;
import com.project.payslip.EmployeePayslip;
import com.project.payslip.MasterDegreeFacultyPayslip;
import com.project.payslip.NonFacultyPayslip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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

    public void writePayrollToFile(Employee employee) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String fileName = "payroll.txt";
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Created new file " + fileName);
                } else {
                    System.out.println("Unable to create new file");
                }
            }
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(employee.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {

        Main app = new Main();
        System.out.println("Welcome to the automated payslip application!");
        Scanner reader = new Scanner(System.in);

        char choice;
        do {
            try {
                System.out.println("\nPlease choose from the options below.");
                System.out.println("1. Add Employee to the system.");
                System.out.println("2. Generate Payslip information of all employees.");
                System.out.println("3. Exit Application");
                choice = reader.nextLine().charAt(0);
                switch (choice) {
                    case '1':
                        EmployeePayslip employeePayslip = app.generateNewEmployeePayslip(reader);
                        if (employeePayslip == null) {
                            System.out.println("Error while processing the employee payslip. Please try again.");
                        } else {
                            System.out.println("Employee payslip processed successfully.");
                        }
                        System.out.println("\n");
                        break;
                    case '2':
                        break;
                    case '3':
                        System.out.println("\nThank you for using the automated portal." +
                                "\nIf you generated payroll slips, you will find the information in a file as well.");
                        break;
                    default:
                        throw new InvalidChoiceException("This choice is not allowed at this moment");
                }
            } catch (InvalidChoiceException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("Starting over...\n");
                choice = '0';
            } catch (InputMismatchException e) {
                System.out.println("\n" + e.getMessage());
                choice = '0';
                reader.nextLine();
            }
        } while (choice != '3');
        reader.close();

    }
}
