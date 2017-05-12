package com.petro.game;

import java.util.List;
import java.util.Random;

/**
 * Created by Администратор on 12.05.2017.
 */
public class GameModel {
    public static final int LOW_BOUND = 0;
    public static final int HIGH_BOUND = 100;
    public static final int WRONG_INPUT = -1;
    private int lowBound;
    private int highBound;
    private int lowBoundChanged;
    private int highBoundChanged;
    private int numberToGuess;
    private int attempts;
    private int lastNumber;
    private StringBuffer log = new StringBuffer();

    public GameModel() {
        lowBound = lowBoundChanged = LOW_BOUND;
        highBound = highBoundChanged = HIGH_BOUND;
    }

    public int getLowBound() {
        return lowBound;
    }

    public void setLowBound(int lowBound) {
        this.lowBound = lowBound;
    }

    public int getHighBound() {
        return highBound;
    }

    public void setHighBound(int highBound) {
        this.highBound = highBound;
    }

    public int getLowBoundChanged() {
        return lowBoundChanged;
    }

    public void setLowBoundChanged(int lowBoundChanged) {
        this.lowBoundChanged = lowBoundChanged;
    }

    public int getHighBoundChanged() {
        return highBoundChanged;
    }

    public void setHighBoundChanged(int highBoundChanged) {
        this.highBoundChanged = highBoundChanged;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public int getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(int lastNumber) {
        this.lastNumber = lastNumber;
    }
    public StringBuffer getLog() {
        return log;
    }

    public void setLog(StringBuffer log) {
        this.log = log;
    }

    public int rand (int low, int high){
        if(!checkBounds(low, high)){
            return WRONG_INPUT;
        }
        lowBound = lowBoundChanged = low;
        highBound = highBoundChanged = high;
        int delta = high - low;
        numberToGuess = low + (int)(Math.random()*(delta +1));
        return numberToGuess;

    }
    public int rand (){
        numberToGuess = (int)(Math.random()* (HIGH_BOUND + 1));
        return numberToGuess;
    }
    public boolean checkBounds (int low, int high){
        if(low <  LOW_BOUND || low >= high || high > HIGH_BOUND){
            return false;
        }
        return true;
    }
    public boolean checkLowBound (int low){
        if(low <  LOW_BOUND || low  >= HIGH_BOUND){
            return false;
        }
        return true;
    }
    public boolean checkHighBound (int high){
        if(high <= lowBound  || high  > HIGH_BOUND){
            return false;
        }
        return true;
    }

    public void changeRange(int inputedNumber) {
        if (inputedNumber < lowBoundChanged || inputedNumber > highBoundChanged){
            return;
        }
        if(inputedNumber < numberToGuess){
            lowBoundChanged = inputedNumber + 1;
        }
        if(inputedNumber > numberToGuess){
            highBoundChanged = inputedNumber - 1;
        }
    }
}
