package org.example.guessingapp;

import java.util.InputMismatchException;

public class ValidationService {
    public static int validateInput(int input) throws InvalidInputException{
       int value = input;
       try {
           if(  value>100
                   || value <1){
               throw new InvalidInputException("Number must be 1 to 100");
           }
           return value;
       }catch (InputMismatchException e){
           throw new InvalidInputException("please enter Number only");
       }
    }


}
