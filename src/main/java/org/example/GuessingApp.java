package org.example;

import org.example.guessingapp.GameConfig;
import org.example.guessingapp.HintService;
import org.example.guessingapp.InvalidInputException;
import org.example.guessingapp.ValidationService;

import java.util.Random;
import java.util.Scanner;


/*
* this branch have game configuration and game rules
* */

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("please enter your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("welcome " + name +" check your luck");

        System.out.println("Please read and understand game rules very carefully");
        System.out.println("1. please enter the valid number 1 to 100.");
        System.out.println("2. you gave only 7 attempts if you guess correct value with in 7 attempts you won other wise you loose.");
        System.out.println("3. you have the 3 clues whenever you guess every wrong values");

        Random rc = new Random();

        GameConfig gc = new GameConfig();
         gc.setTargetNumber(
             rc.nextInt(gc.getMAX() -1 + gc.getMIN())+ gc.getMIN()
        );

        // UC : 2

        System.out.println("Now you entering the real game world !");

        int targetNumber = gc.getTargetNumber();

        System.out.println("please enter valid number between 1 to 100");
        //int result=0;
try {
    int result = sc.nextInt();
    ValidationService.validateInput(result);


    int attempt = 0;
    // boolean loose = false;

    int hint = 1;

    while (targetNumber != result
            && attempt <= gc.getMAX_ATTEMPT()) {
//                if (targetNumber > result) {
//                    System.out.println("you guess low");
//                    attempt++;
//                    loose = true;
//                } else if (targetNumber < result) {
//                    System.out.println("you guess high");
//                    attempt++;
//                    loose = true;
//                }
        if (hint < gc.getMAX_HINT()) {
            String message = HintService.getHintCount(targetNumber, hint);
            System.out.println("message " + message);
        }
        System.out.println("you guessing wrong Number , please try agin....!");
        result = sc.nextInt();
        ValidationService.validateInput(result);

        attempt++;
        hint++;
    }


//        System.out.println("  attempt " +   attempt++);
//        System.out.println("  hint " +   hint);
    System.out.println("target Number " + targetNumber);

    if (targetNumber == result) {
        System.out.println("congrats your won");
    }

    }catch (Exception e){
    throw new InvalidInputException("please enter Number only");
    }

}
}