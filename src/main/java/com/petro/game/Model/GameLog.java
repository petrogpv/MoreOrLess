package com.petro.game.model;

/**
 * Created by Администратор on 14.05.2017.
 */
public class GameLog {

    private int attempt;
    private int inputtedNumber;
    private int lowRangeBound;
    private int highRangeBound;

    public GameLog() {
    }

    public GameLog(int attempt, int inputtedNumber, int lowRangeBound, int highRangeBound) {
        this.attempt = attempt;
        this.inputtedNumber = inputtedNumber;
        this.lowRangeBound = lowRangeBound;
        this.highRangeBound = highRangeBound;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getInputtedNumber() {
        return inputtedNumber;
    }

    public void setInputtedNumber(int inputtedNumber) {
        this.inputtedNumber = inputtedNumber;
    }

    public int getLowRangeBound() {
        return lowRangeBound;
    }

    public void setLowRangeBound(int lowRangeBound) {
        this.lowRangeBound = lowRangeBound;
    }

    public int getHighRangeBound() {
        return highRangeBound;
    }

    public void setHighRangeBound(int highRangeBound) {
        this.highRangeBound = highRangeBound;
    }

    @Override
    public String toString() {
        return  "Attempt = " + attempt +
                ", inputtedNumber = " + inputtedNumber +
                ", Range = [" + lowRangeBound + " - "+ highRangeBound +']';
    }
}
