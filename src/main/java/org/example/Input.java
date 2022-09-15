package org.example;

import java.util.Scanner;

public class Input {
    public Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
    }

    public String returnString(){
        System.out.println("Write your name and press enter.");
        return scanner.next();
    }
    public boolean returnDoIt(){
        boolean isValid = false;
        boolean tempB = false;
        while(!isValid) {
            System.out.println("Press Y/N and than enter.");
            String userInput = scanner.next().toUpperCase();
            if (userInput.equals("Y")) {
                isValid = true;
                tempB = true;
            }
            if (userInput.equals("N")) {
                isValid = true;
                tempB = false;
            }
        }
        return tempB;
    }
}
