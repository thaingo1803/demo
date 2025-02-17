/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.EmployeeInputter;
import bo.EmployeeManager;
import entity.Employee;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author thai
 */
public class EmployeeManagementController {

    private EmployeeInputter employeeInputter;
    private EmployeeManager employeeManager;

    public EmployeeManagementController() {
        employeeManager = new EmployeeManager();
    }

    private Employee inputEmployee() {
        employeeInputter = new EmployeeInputter();
        Employee e = employeeInputter.getInputOfEmployee();
        return e;
    }

    //add
    public Employee addEmployee() {
        Employee e = inputEmployee();
        if (employeeManager.addEmployee(e)) {
            return e;
        }
        return null;
    }

    //update
    public Employee updateEmployee() throws IndexOutOfBoundsException {
        int id = Validation.checkInputInteger("Enter id of Employee you want to upadate:");
        if (employeeManager.searchEmployeeById(id) == -1) {
            throw new IndexOutOfBoundsException("Not found!");
        }
        Employee e = inputEmployee();
        return employeeManager.updateEmployee(id, e);
    }

    //remove
    public Employee removeEmployee() throws IndexOutOfBoundsException {
        int id = Validation.checkInputInteger("Enter id of Employee you want to remove:");
        int index = employeeManager.searchEmployeeById(id);
        if (index == -1) {
            throw new IndexOutOfBoundsException("Not found!");
        }
        Employee e = employeeManager.getEmployeeById(id);
        if (employeeManager.deleteEmployee(e)) {
            return e;
        }
        return null;
    }

    //search
    public ArrayList<Employee> searchEmployeeByName() throws Exception {
        ArrayList<Employee> searchList = new ArrayList<>();
        String name = Validation.checkInputString("Enter first or last name of Employee you want to looking for:");
        return employeeManager.searchEmployeeByName(name);
    }

    //getList
    public ArrayList<Employee> getSortList() {
        return employeeManager.sortEmployeeListBySalary();
    }
    
    //save data
    public void saveDataToFile() throws Exception{
        employeeManager.saveData();
    }
    
    //load data from file
    
    public void loadDataFromFile() throws FileNotFoundException{
        employeeManager.loadFromFile();
    }

}
