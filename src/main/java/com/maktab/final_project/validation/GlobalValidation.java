package com.maktab.final_project.validation;

public class GlobalValidation {

    public static String stringValidation(String input) {
        String result = "";
        if (input.matches("\\d+")) {
            result = "FirstName And LastName Cant Be Numeric";
        }
        return result;
    }

    public static String passwordValidation(String input){
        String result = "";
        if (!input.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8}$")) {
            result = "Password Must Have Length Of 8 And Combine Of Numbers And Letters";
        }
        return result;
    }

}