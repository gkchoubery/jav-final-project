package com.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static final String FILE_NAME = "payroll.txt";

    public static void writeDataToFile(String data) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String fileName = FILE_NAME;
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
            bufferedWriter.write(data + "\n");
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

    public static void printToFile(String data) {
//        System.out.println(data);
        writeDataToFile(data);
    }


    public static void main(String[] args) {

        EmployeePayslipManagement payslipManagement = new EmployeePayslipManagement();
        System.out.println("Welcome to the automated payslip application!\n\n");
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter the month and year you want to process payslips for (MONTH, yyyy): ");
        String monthYear = reader.nextLine();
        System.out.println("\nAdd details for the employees below...");
        System.out.println("Note: Once you have added the all the employee data, the report will be generated automatically.\n");
        char choice;
        do {
            try {
                EmployeePayslip employeePayslip = payslipManagement.generateNewEmployeePayslip(reader);
                if (employeePayslip == null) {
                    System.out.println("Error while processing the employee payslip. Please try again.");
                } else {
                    payslipManagement.addEmployeePayslip(employeePayslip);
                    System.out.println("Employee payslip entered successfully.");
                }
                System.out.println("Do you want to add another employee? Choose any key to add another employee or 'N' to exit: ");
                choice = reader.next().toUpperCase().charAt(0);
                reader.nextLine();
            } catch (InvalidChoiceException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("Starting over...\n");
                choice = 'Y';
            } catch (InputMismatchException e) {
                System.out.println("\n" + e.getMessage());
                choice = 'Y';
                reader.nextLine();
            }
        } while (choice != 'N');
        System.out.println("\nThank you for using the automated portal." +
                "\nYou will find all the processed payslips data in \"" + FILE_NAME + "\"");
        printToFile(Utils.centerPad("Generating payroll information for " + monthYear,
                80, '*') + "\n\n");

        for (EmployeePayslip payslip :
                payslipManagement.getEmployeePayslips()) {
            printToFile(payslip.toString());
        }

        printToFile(Utils.rightPad("Total number of employee payslips processed: ") +
                payslipManagement.getNumberOfProcessedPayslips());
        printToFile(Utils.rightPad("Total number of faculty payslips processed: ") +
                payslipManagement.getNumberOfFacultyProcessed());
        printToFile(Utils.rightPad("Total number of non-faculty payslips processed: ") +
                payslipManagement.getNumberOfNonFacultyProcessed());

        printToFile(Utils.centerPad("End of report", 80, '*') + "\n");

        reader.close();

    }
}
