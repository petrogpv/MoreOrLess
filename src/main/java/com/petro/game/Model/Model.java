package com.petro.game.Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 12.05.2017.
 */
public class Model {
    public static final int LOW_BOUND_DEFAULT = 0;
    public static final int HIGH_BOUND_DEFAULT = 100;
    public static final int WRONG_INPUT = -1;
    public static final int ONE_INT = 1;
    private int lowBoundAtStart;
    private int highBoundAtStart;
    private int lowBound;
    private int highBound;
    private int numberToGuess;
    private int attempts;
    private int lastNumber;
    private List<GameLog> log = new LinkedList<>();

    public Model() {
        lowBoundAtStart = lowBound = LOW_BOUND_DEFAULT;
        highBoundAtStart = highBound = HIGH_BOUND_DEFAULT;
    }

    public int getLowBoundAtStart() {
        return lowBoundAtStart;
    }

    public void setLowBoundAtStart(int lowBoundAtStart) {
        this.lowBoundAtStart = lowBoundAtStart;
    }

    public int getHighBoundAtStart() {
        return highBoundAtStart;
    }

    public void setHighBoundAtStart(int highBoundAtStart) {
        this.highBoundAtStart = highBoundAtStart;
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

    public List<GameLog> getLog() {
        return log;
    }

    public int rand(int low, int high) {
        if (!checkBounds(low, high)) {
            return WRONG_INPUT;
        }
        lowBoundAtStart = lowBound = low;
        highBoundAtStart = highBound = high;
        int delta = high - low;
        numberToGuess = low + (int) (Math.random() * (delta + ONE_INT));
        return numberToGuess;

    }

    public int rand() {
        numberToGuess = (int) (Math.random() * (HIGH_BOUND_DEFAULT + ONE_INT));
        return numberToGuess;
    }

    public boolean checkBounds(int low, int high) {
        if (low < LOW_BOUND_DEFAULT || low >= high || high > HIGH_BOUND_DEFAULT) {
            return false;
        }
        return true;
    }

    public boolean checkLowBound(int low) {
        if (low < LOW_BOUND_DEFAULT || low >= HIGH_BOUND_DEFAULT) {
            return false;
        }
        return true;
    }

    public boolean checkHighBound(int high) {
        if (high <= lowBoundAtStart || high > HIGH_BOUND_DEFAULT) {
            return false;
        }
        return true;
    }

    private void changeRange() {
        if (lastNumber < lowBound || lastNumber > highBound) {
            return;
        }
        if (lastNumber < numberToGuess) {
            lowBound = lastNumber + ONE_INT;
        }
        if (lastNumber > numberToGuess) {
            highBound = lastNumber - ONE_INT;
        }
    }

    public void changeModel(int inputtedNumber) {
        attempts++;
        lastNumber = inputtedNumber;
        changeRange();
        writeLog();
    }

    private void writeLog() {
        GameLog gl = new GameLog(attempts, lastNumber, lowBound, highBound);
        log.add(gl);
    }
}
