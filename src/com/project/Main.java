package com.project;

import com.project.employee.Employee;
import com.project.exceptions.InvalidChoiceException;
import com.project.payslip.EmployeePayslip;
import com.project.utilities.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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

        EmployeePayslipManagement payslipManagement = new EmployeePayslipManagement();
        System.out.println("Welcome to the automated payslip application!\n\n");
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter the month and year you want to process payslips for (MONTH, yyyy): ");
        String monthYear = reader.nextLine();

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
                        EmployeePayslip employeePayslip = payslipManagement.generateNewEmployeePayslip(reader);
                        if (employeePayslip == null) {
                            System.out.println("Error while processing the employee payslip. Please try again.");
                        } else {
                            payslipManagement.addEmployeePayslip(employeePayslip);
                            System.out.println("Employee payslip processed successfully.");
                        }
                        System.out.println("\n");
                        break;
                    case '2':
                        System.out.println(Utils.centerPad("Generating payroll for " + monthYear, 70, '*') + "\n\n");
                        System.out.println(Utils.rightPad("Total number of employee payslips processed: ") +
                                payslipManagement.getNumberOfProcessedPayslips());
                        System.out.println(Utils.rightPad("Total number of faculty payslips processed: ") +
                                payslipManagement.getNumberOfFacultyProcessed());
                        System.out.println(Utils.rightPad("Total number of non-faculty payslips processed: ") +
                                payslipManagement.getNumberOfNonFacultyProcessed());
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
