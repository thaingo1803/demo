/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.EmployeeManagementController;
import entity.Employee;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author thinh
 */
public class Main {

    public static void main(String[] args) throws Exception {
        EmployeeManagementController employeeManagementController = new EmployeeManagementController();
        String menu = "=================================================== Employee management ===================================================\n"
                + "1.Add employees \n"
                + "2.Update employees\n"
                + "3.Remove employees\n"
                + "4.Search employees\n"
                + "5.Sort employees by salary\n"
                + "6.Save data to file\n"
                + "7.Load data from file\n"
                + "8.Exit.\n"
                + "---------------------------------------------------------------------------------------------------------------------------------";
        int choice = 0;
        while (choice != 8) {
            System.out.println(menu);
            choice = Validation.checkInputIntegerInRange("Enter your choice:", 1, 8);
            switch (choice) {
                case 1:
                    System.out.println("---------------------------------- add employee -------------------------------------");
                    if (employeeManagementController.addEmployee() == null) {
                        System.err.println("Fali!");
                    } else {
                        System.out.println("Done!");
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------- update employee -----------------------------------");
                    if (employeeManagementController.getSortList().isEmpty()) {
                        System.err.println("The list is Empty!");
                        break;
                    }
                    try {
                        if (employeeManagementController.updateEmployee() == null) {
                            System.err.println("Fali!");
                        } else {
                            System.out.println("Done!");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Not found this id!");
                    }
                    break;
                case 3:
                    System.out.println("--------------------------------- delete employee -----------------------------------");
                    if (employeeManagementController.getSortList().isEmpty()) {
                        System.err.println("The list is Empty!");
                        break;
                    }
                    try {
                        if (employeeManagementController.removeEmployee() == null) {
                            System.err.println("Fail!");
                        } else {
                            System.out.println("Done!");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Not found this id!");
                    }
                    break;
                case 4:
                    System.out.println("--------------------------------- search employee -----------------------------------");
                    if (employeeManagementController.getSortList().isEmpty()) {
                        System.err.println("The list is Empty!");
                        break;
                    }
                    ArrayList<Employee> searchResults = employeeManagementController.searchEmployeeByName();
                    if (searchResults.isEmpty()) {
                        System.err.println("Not found this name!");
                    } else {
                        for (Employee item : searchResults) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 5:
                    System.out.println("--------------------------------- sort employee -----------------------------------");
                    if (employeeManagementController.getSortList().isEmpty()) {
                        System.err.println("The list is Empty!");
                        break;
                    }
                    System.out.println("--------------------------------------------------- list of employee ----------------------------------------------------");
                    System.out.println(Employee.DISPLAY_HEADER);
                    for (Employee employee : employeeManagementController.getSortList()) {
                        System.out.println(employee);
                    }
                    System.out.println("Done!");
                    break;
                case 6:
                    System.out.println("--------------------------------- save data -----------------------------------");
                    if (employeeManagementController.getSortList().isEmpty()) {
                        System.err.println("The list is Empty!You need to add some employee or load the data from file first");
                        break;
                    }
                    try {
                        employeeManagementController.saveDataToFile();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 7:
                    System.out.println("--------------------------------- load data -----------------------------------");
                    try {
                        employeeManagementController.loadDataFromFile();
                        System.out.println("Done!");
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
            }
        }
    }
}
