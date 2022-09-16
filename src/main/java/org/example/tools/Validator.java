package org.example.tools;

public class Validator {

    public static boolean isValidName(String name){
        boolean flag = true;
        if(name.length() > 12){
            flag = false;
            return flag;
        }
        for(char c : name.toCharArray()){
            if(!Character.isLetter(c)){
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public Validator (){

    }
}
