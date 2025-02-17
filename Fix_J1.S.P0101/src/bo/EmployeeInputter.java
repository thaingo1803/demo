/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Employee;
import utils.Validation;

/**
 *
 * @author thinh
 */
public class EmployeeInputter {
    private Employee e;

    public EmployeeInputter() {
        e = new Employee();
    }
    
    public Employee getEmployeeInformation(){
        return e;
    }
    //Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Agen
    private void inputEployeeInformation(){
        e.setFirstName(Validation.checkInputString("Enter first name of employee:"));
        e.setLastName(Validation.checkInputString("Enter last name of employee:"));
        e.setPhoneNumber(Validation.checkInputPhone("Enter phone number of employee:"));
        e.setEmail(Validation.checkInputEmail("Enter email of employee:"));
        e.setAddress(Validation.checkInputString("Enter address of employee:"));
        e.setdOB(Validation.checkisDateValid("Enter date of birth:"));
        e.setSex(Validation.checkGenderInput("choose type of gender 1(male)--2(female):"));
        e.setSalary(Validation.checkInputDouble("Enter salary of employee"));
        e.setAgen(Validation.checkInputString("Enter agen of employee:"));
    }
    
    public Employee getInputOfEmployee(){
        inputEployeeInformation();
        return e;
    }
}
