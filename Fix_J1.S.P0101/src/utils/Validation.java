/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Gender;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    private static final String PHONE_VALID = "^\\d{10}\\d*$";
    
    //check String all 
    public static String checkInputString(String mess) {
        System.out.println(mess);
        while (true) {
            String input = sc.nextLine().trim();
            input = input.replaceAll("\\s+", "");
            if (input.isEmpty()) {
                System.err.println("Input can't be empty!");
                System.out.print("Enter again:");
            } else if (!input.matches("^[a-zA-Z]+$")) {
                System.err.println("Input must contain only alphabet characters!");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    //check input normal String is not empty
    public static String checkNormalInputString(String input) {
        System.out.println(input);
        while (true) {
            String mess = sc.nextLine();
            if (mess.isEmpty()) {
                System.err.println("Input can not be empty!");
                System.out.print("Enter again: ");
            } else {
                return mess;
            }
        }
    }

    //check imput integer
    public static int checkInputInteger(String mess) {
        System.out.println(mess);
        while (true) {
            try {

                int number = Integer.parseInt(sc.nextLine());
                if (number < 0) {
                    System.err.println("Input must be greater than 0!");
                    System.out.print("Enter again: ");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Input must be an integer!");
                System.out.print("Enter again: ");
            }
        }
    }

    //check input in range min max
    public static int checkInputIntegerInRange(String mess, int minNumber, int maxNumber) {
        while (true) {
            int number = checkInputInteger(mess);
            if (number < minNumber || number > maxNumber) {
                System.err.println("Input must be an Integer in rage [" + minNumber + "]" + "[" + maxNumber + "]");
                System.out.print("Enter again: ");
            } else {
                return number;
            }
        }
    }
//
    //check input double

    public static double checkInputDouble(String mess) {
        System.out.println(mess);
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number <= 0) {
                    System.err.println("Input must be a double greater than 0!\nEnter again:");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Input must be a double number!");
                System.out.print("Enter again: ");
            }
        }
    }

    //check date
    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static String checkisDateValid(String mess) {
        while (true) {
            String date = checkNormalInputString(mess);
            try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                df.setLenient(false);
                df.parse(date);
                Date d = df.parse(date);
                if (2023 - d.getYear() <= 20) {
                    System.err.println("Age must be under or equal 20!");
                    System.out.println("Enter again: ");
                }
                return date.replaceAll("\\s+", "").trim();
            } catch (ParseException e) {
                System.err.println("Invalid date!");
                System.out.print("Enter again: ");
            }
        }
    }

    //check gender
    public static Gender checkGenderInput(String mess) {
        int choice = checkInputIntegerInRange(mess, 1, 2);
        return Gender.getGenderByInt(choice);
    }

    //email
    public static String checkInputEmail(String mess) {
        while (true) {
            String email = checkNormalInputString(mess);
            if (email.matches(EMAIL_VALID) && email.length() < 24) {
                return email;
            } else {
                System.err.println("Email must be like this 123@123.");
                System.out.print("Enter again: ");
            }
        }
    }

    //check phone
    public static String checkInputPhone(String mess) {
        while (true) {
            String phone = checkNormalInputString(mess);
            if (phone.matches(PHONE_VALID) && phone.length() == 10) {
                return phone;
            } else {
                System.err.println("Phone is number with minimum 10 number!");
                System.out.print("Enter again: ");
            }
        }
    }
}
