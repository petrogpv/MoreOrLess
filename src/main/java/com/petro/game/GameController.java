package com.petro.game;

import java.util.Scanner;

/**
 * Created by Администратор on 12.05.2017.
 */
public class GameController {
    private GameModel gameModel;
    private GameView gameView;
    private int numberToGuess;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        initializeGame(sc);
        numberToGuess = gameModel.getNumberToGuess();
        playGame(sc);

        sc.close();
    }

    private void playGame(Scanner sc) {
        gameView.printMessage(GameView.GAME_STARTED);
        int currentNumber;
        String currentLog;
        while (true) {
            gameView.printMessage(GameView.NEXT_LINE + GameView.INPUT_NUMBER);
            if (!sc.hasNextInt()) {
                gameView.printMessage(GameView.WONG_INPUT);
                sc.next();
                continue;
            }
            currentNumber = sc.nextInt();

            if (currentNumber == numberToGuess) {
                changeModel(currentNumber);
                writeLog();
                break;
            }

            gameView.printMessage(GameView.MISSMATCH + GameView.NUMBER_IS);

            if (currentNumber > gameModel.getHighBoundChanged()
                    || currentNumber < gameModel.getLowBoundChanged()) {
                gameView.printMessage(GameView.OUT_OF_RANGE);
            } else if (currentNumber > numberToGuess) {
                gameView.printMessage(GameView.LESS);
            } else if (currentNumber < numberToGuess) {
                gameView.printMessage(GameView.GREATER);
            }
                changeModel(currentNumber);
                currentLog = writeLog();

            gameView.printMessage(GameView.NEXT_LINE + currentLog);


        }
        gameView.printMessage(GameView.YOU_WON );
        gameView.printMessage(String.valueOf(currentNumber) + GameView.NEXT_LINE + GameView.NEXT_LINE);
        gameView.printMessage(GameView.GAME_STATISTIC);
        gameView.printMessage(GameView.START_RANGE + gameModel.getLowBound() + GameView.DASH +
                gameModel.getHighBound() + GameView.NEXT_LINE);
        gameView.printMessage(GameView.TOTAL_ATTEMPTS + gameModel.getAttempts() + GameView.NEXT_LINE);
        gameView.printMessage(gameModel.getLog().toString());
        gameView.printMessage(GameView.NEXT_LINE + GameView.GAME_LOGS);

    }

    private String writeLog() {
        StringBuffer log = gameModel.getLog();
        StringBuffer currentLog = new StringBuffer();

        currentLog.append(GameView.ATTEMPTS)
                .append(gameModel.getAttempts())
                .append(GameView.CURRENT_RANGE)
                .append(gameModel.getLowBoundChanged())
                .append(GameView.DASH)
                .append(gameModel.getHighBoundChanged())
                .append(GameView.LAST_INPUT)
                .append(gameModel.getLastNumber())
                .append(GameView.NEXT_LINE);
        log.append(currentLog);
        return currentLog.toString();
    }

    public void initializeGame(Scanner sc) {
        while (true) {
            gameView.printMessage(GameView.START_GAME);
            gameView.printMessage(GameView.YOUR_CHOICE);

            if (!sc.hasNextInt()) {
                gameView.printMessage(GameView.WONG_INPUT);
                sc.next();
                continue;
            }

            int gameType = sc.nextInt();

            switch (gameType) {
                case 1:
                    numberToGuess = gameModel.rand();
                    break;
                case 2:
                    numberToGuess = manualBoundsInput(sc);
                    break;
                default:
                    gameView.printMessage(GameView.WONG_INPUT);
                    continue;
            }
            break;
        }

    }

    public int manualBoundsInput(Scanner sc) {

        gameView.printMessage(GameView.INPUT_LOW_BOUND);
        int low = sc.nextInt();

        while (!gameModel.checkLowBound(low)) {
            gameView.printMessage(GameView.WONG_INPUT);
            low = sc.nextInt();
        }
        gameModel.setLowBound(low);

        printForHighBoundInput();
        int high = sc.nextInt();

        while (!gameModel.checkHighBound(high)) {
            gameView.printMessage(GameView.WONG_INPUT);
            printForHighBoundInput();
            high = sc.nextInt();
        }
        gameModel.setHighBound(high);

        return gameModel.rand(low, high);

    }

    public void printForHighBoundInput() {
        gameView.printMessage(GameView.INPUT_HIGH_BOUND);
        gameView.printMessage(String.valueOf(gameModel.getLowBound() + 1));
        gameView.printMessage(String.valueOf(GameView.TO));
        gameView.printMessage(String.valueOf(GameModel.HIGH_BOUND));
        gameView.printMessage(String.valueOf(GameView.COLON));
    }

    public void changeModel(int inputedNumber) {
        gameModel.setAttempts(gameModel.getAttempts() + 1);
        gameModel.setLastNumber(inputedNumber);
        gameModel.changeRange(inputedNumber);
    }


}
