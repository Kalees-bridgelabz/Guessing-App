package org.example.guessingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StorageServices {

    public static void saveResult(String player, int attempts, boolean win) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("game_result.txt", true))) {

            bufferedWriter.write("Player: " + player +
                    ", Attempts: " + attempts +
                    ", Result: " + (win ? "WIN" : "LOSS"));
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Unable to save game result .");
        }
    }
}
