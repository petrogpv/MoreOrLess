package com.petro.game.view;

import com.petro.game.model.GameLog;
import com.petro.game.model.Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 12.05.2017.
 */
public class View implements ViewConstants {
    public static final String COLON_SIGN = " : ";
    public static final String DASH_SIGN = " - ";
    public static final int ONE_INT = 1;


    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printMessage(String string) {
        System.out.print(string);
    }

    public void printStartGame() {
        printMessage(START_GAME);
    }

    public void printWrongInput() {
        printMessage(WONG_INPUT);
    }

    public void printInputLowBound() {
        printMessage(INPUT_LOW_BOUND);
    }

    public void printInputHighBound(Model model) {
        String str = concatenationString(INPUT_HIGH_BOUND,
                String.valueOf(model.getLowBoundAtStart() + ONE_INT),
                TO,
                String.valueOf(model.HIGH_BOUND_DEFAULT),
                COLON_SIGN);
        printMessage(str);
    }

    public void printGameStarted() {
        printMessage(GAME_STARTED);
    }

    public void printInputNumber() {
        printMessage(INPUT_NUMBER);
    }

    public void printCurrentLog(Model model) {
        List<GameLog> log = model.getLog();
        if (log instanceof LinkedList) {
            printMessage(((LinkedList<GameLog>) log).getLast().toString());
        }
    }

    public void printResult(Model model) {
        StringBuilder sb = new StringBuilder();
        for (GameLog gl : model.getLog()) {
            sb.append(gl.toString())
                    .append("\n");

        }
        String str = concatenationString(YOU_WON,
                String.valueOf(model.getLastNumber()),
                GAME_STATISTIC,
                START_RANGE,
                String.valueOf(model.getLowBoundAtStart()),
                DASH_SIGN,
                String.valueOf(model.getHighBoundAtStart()),
                TOTAL_ATTEMPTS,
                String.valueOf(model.getAttempts()),
                GAME_LOGS,
                sb.toString()
        );
        printMessage(str);

    }

    public void printMismatch() {
        printMessage(MISMATCH);
    }

    public void printOutOfRange() {
        printMessage(OUT_OF_RANGE);
    }

    public void printLess() {
        printMessage(LESS);
    }

    public void printGreater() {
        printMessage(GREATER);
    }


}
