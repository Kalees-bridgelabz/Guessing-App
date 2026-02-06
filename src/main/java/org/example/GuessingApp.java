package org.example;

import org.example.guessingapp.*;

import java.util.Random;
import java.util.Scanner;


/*
* this branch have game configuration and game rules
* */

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("please enter your name");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.println("welcome " + name + " check your luck");

            System.out.println("Please read and understand game rules very carefully");
            System.out.println("1. please enter the valid number 1 to 100.");
            System.out.println("2. you gave only 7 attempts if you guess correct value with in 7 attempts you won other wise you loose.");
            System.out.println("3. you have the 3 clues whenever you guess every wrong values");

            Random rc = new Random();

            GameConfig gc = new GameConfig();
            gc.setTargetNumber(
                    rc.nextInt(gc.getMAX() - 1 + gc.getMIN()) + gc.getMIN()
            );

            // UC : 2

            System.out.println("Now you entering the real game world !");

            int targetNumber = gc.getTargetNumber();

            System.out.println("please enter valid number between 1 to 100");
            try {
                int result = sc.nextInt();
                ValidationService.validateInput(result);


                int attempt = 0;

                int hint = 1;

                while (targetNumber != result
                        && attempt < gc.getMAX_ATTEMPT()) {
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
                System.out.println("target Number " + targetNumber);


                boolean finalResult = false;

                if (targetNumber == result) {
                    System.out.println("congrats your won");
                    finalResult = true;
                } else {
                    System.out.println("Sorry you loss the game");
                    finalResult = false;
                }

                StorageServices.saveResult(name, attempt, finalResult);


            } catch (Exception e) {
                throw new InvalidInputException("please enter Number only");
            }
            System.out.println("If you want continue or play again this game please type :(YES)");
            System.out.println("If you want Exit this game please type :(NO)");
            Scanner opt = new Scanner(System.in);
            String option = opt.nextLine();
            if (option.equalsIgnoreCase("yes")) {
                playAgain = true;
            }else{
                playAgain = false;
                sc.close();
                opt.close();
            }
        }

}
}