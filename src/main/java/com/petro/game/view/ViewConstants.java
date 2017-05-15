package com.petro.game.view;

import java.util.Locale;
import java.util.ResourceBundle;


public interface ViewConstants {
    String MESSAGES_BUNDLE_NAME = "messages";
    ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                    new Locale("ua"));  // Ukrainian
//                    new Locale("en"));        // English
    String START_GAME = bundle.getString("input.start.game");
    String INPUT_LOW_BOUND = bundle.getString("input.low.bound");
    String INPUT_HIGH_BOUND = bundle.getString("input.high.bound");
    String TO = bundle.getString("input.to");
    String WONG_INPUT = bundle.getString("input.wrong.input");
    String GAME_STARTED = bundle.getString("input.game.started");
    String INPUT_NUMBER = bundle.getString("input.number");
    String MISMATCH = bundle.getString("input.mismatch");
    String OUT_OF_RANGE = bundle.getString("input.out.of.range");
    String GREATER = bundle.getString("input.greater");
    String LESS = bundle.getString("input.less");
    String YOU_WON = bundle.getString("input.you.won");
    String START_RANGE = bundle.getString("input.start.range");
    String TOTAL_ATTEMPTS = bundle.getString("input.total.attempts");
    String GAME_LOGS = bundle.getString("input.game.logs");
    String GAME_STATISTIC = bundle.getString("input.game.statistic");

}
