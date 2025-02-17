/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Employee;
import entity.Gender;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author thinh
 */
public class EmployeeManager {

    private ArrayList<Employee> employeesList;
    private int lastId;

    public EmployeeManager() {
        employeesList = new ArrayList<>();
        lastId = employeesList.size();
    }

    //add employee
    /*
        id tự tăng vì nó lấy ra cái id mới nhất
        cái list khai báo employeesList sẽ thêm 1 employee mới vào list
     */
    public boolean addEmployee(Employee e) {
        lastId++;
        e.setId(lastId);
        return employeesList.add(e);
    }

    //search by id
    /* */
    public int searchEmployeeById(int id) {
        for (int index = 0; index < employeesList.size(); index++) {
            if (employeesList.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    // search by name
    public ArrayList<Employee> searchEmployeeByName(String name) throws Exception {
        ArrayList<Employee> searchList = new ArrayList<>(); // 

        for (int index = 0; index < employeesList.size(); index++) {
            if (employeesList.get(index).getLastName().equalsIgnoreCase(name) || employeesList.get(index).getFirstName().equalsIgnoreCase(name)) {
                searchList.add(employeesList.get(index));
            }
        }
        return searchList;
    }

    //remove
    public Boolean deleteEmployee(Employee e) {
        return employeesList.remove(e);
    }

    //
    //update employee
    public Employee updateEmployee(int id, Employee e) {
        e.setId(id);
        return employeesList.set(searchEmployeeById(id), e);
    }

    //get employee by id
    public Employee getEmployeeById(int id) {
        return employeesList.get(searchEmployeeById(id));
    }

    //sort list of employee by salary
    public ArrayList<Employee> sortEmployeeListBySalary() {
        Collections.sort(employeesList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        return employeesList;
    }

    // save data to the text file
    public void saveData() throws Exception {
        try {
            FileWriter fileWriter = new FileWriter(/* có thể thay thế đường dẫn đến 1 file bất kì mà mình muốn*/"D:\\data.txt");// nếu như file txt ban đầu chưa có thì bản chất nó sẽ tìm đến cái địa chỉ trước nếu như không có thì nó sẽ mặc định tạo ra 1 file với tên đã điền sẵn ở đó
            for (Employee e : employeesList) {
                fileWriter.write(e.toString()+"\n");            
            }fileWriter.close();
        } catch (Exception e) {
            throw new Exception("Something wrong!the data can not be save");
        }
        System.out.println("Done!");
    }

    // load dữ liệu từ file
    public void loadFromFile() throws FileNotFoundException {
        String url = "D:\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        try {
            while (scanner.hasNextLine()) {
                String employee = scanner.nextLine();
                String[] emString = employee.split("\\|");
                if (emString.length == 10) { 
                    Employee e = new Employee();
                    
                    e.setId(employeesList.size()+1);
                    e.setFirstName(emString[1].trim());
                    e.setLastName(emString[2].trim());
                    e.setPhoneNumber(emString[3].trim());
                    e.setEmail(emString[4].trim());
                    e.setAddress(emString[5].trim());
                    e.setdOB(emString[6].trim());
                    if (emString[7].trim().equals("MALE")) {
                        e.setSex(Gender.getGenderByInt(1));
                    } else {
                        e.setSex(Gender.getGenderByInt(2));
                    }
                    e.setSalary(Double.parseDouble(emString[8].trim()));
                    e.setAgen(emString[9].trim());
                    employeesList.add(e);
                } else {
                    System.out.println("Invalid data format: " + employee);
                }
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
