package org.example.guessingapp;

public class GameConfig {
    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }

    public int getMAX_ATTEMPT() {
        return MAX_ATTEMPT;
    }

    public int getMAX_HINT() {
        return MAX_HINT;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public GameConfig(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public GameConfig() {
    }

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPT = 7;
    private final int MAX_HINT = 3;
    int targetNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}


