package org.example;

import org.example.guessingapp.GameConfig;

import java.util.Random;
import java.util.Scanner;
/*
* this branch have game configuration and game rules
* */

public class GuessingApp {
    public static void main(String[] args) {
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



    }
}