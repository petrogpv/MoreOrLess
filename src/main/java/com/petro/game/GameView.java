package com.petro.game;

/**
 * Created by Администратор on 12.05.2017.
 */
public class GameView {
    public static final String START_GAME = "To start game please choose type. \n" +
                                            "Auto range - input \"1\"\nManual range - input \"2\"\n";
    public static final String YOUR_CHOICE = "Your choice: ";
    public static final String INPUT_LOW_BOUND = "Input low bound (0-99): ";
    public static final String INPUT_HIGH_BOUND = "Input high bound from ";
    public static final String TO = " to ";
    public static final String COLON = ":  ";
    public static final String DASH = " - ";
    public static final String NEXT_LINE = "\n";
    public static final String WONG_INPUT = "Wrong input!\n";
    public static final String GAME_STARTED = "Game started!\n";
    public static final String INPUT_NUMBER = "Input your number: ";
    public static final String MISSMATCH = "Missmatch!\n";
    public static final String NUMBER_IS = "The secret number is ";
    public static final String OUT_OF_RANGE = "Out of range!\n";
    public static final String GREATER = "greater!";
    public static final String LESS = "less!";
    public static final String ATTEMPTS = "Attempts: ";
    public static final String CURRENT_RANGE = ", Current range: ";
    public static final String LAST_INPUT = ", Last input: ";
    public static final String YOU_WON = "You won! The secret number was ";
    public static final String GAME_STATISTIC = "Game statistic: \n";
    public static final String START_RANGE = "Start range: ";
    public static final String TOTAL_ATTEMPTS = "Total attempts: ";
    public static final String GAME_LOGS = "Game logs: ";


    public void printMessage (String string){
        System.out.print(string);
    }
}
