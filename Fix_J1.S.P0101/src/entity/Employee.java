/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author thai
 */
//Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Agen
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dOB;
    private Gender sex;
    private double salary;
    private String agen;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phoneNumber, String email, String address, String dOB, Gender sex, double salary, String agen) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.dOB = dOB;
        this.sex = sex;
        this.salary = salary;
        this.agen = agen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgen() {
        return agen;
    }

    public void setAgen(String agen) {
        this.agen = agen;
    }

    @Override
    public String toString() {
        return String.format(Employee_DISPLAY_FORMAT, id, firstName, lastName, phoneNumber, email, address, dOB, sex, incomes(salary), agen);
    }

    private String incomes(double income) {
        BigDecimal getIncome = new BigDecimal(income);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        String formattedSalaryString = decimalFormat.format(getIncome);
        return formattedSalaryString;
    }

    //Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Agen
    public static final String Employee_DISPLAY_FORMAT = " %3s|%13s|%13s|%13s|%26s|%13s|%11s|%7s|%16s|%13s\n";

    public static String DISPLAY_HEADER = String.format(Employee_DISPLAY_FORMAT, "id", "first name", "last name", "phone", "email", "address", "dob", "sex", "salary", "agen");

}
