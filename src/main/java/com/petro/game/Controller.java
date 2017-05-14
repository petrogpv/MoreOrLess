package com.petro.game;

import com.petro.game.model.Model;
import com.petro.game.view.View;

import java.util.Scanner;

/**
 * Created by Администратор on 12.05.2017.
 */
public class Controller {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    private Model model;
    private View view;
    private int numberToGuess;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        initializeGame(sc);
        playGame(sc);
        sc.close();
    }

    private void playGame(Scanner sc) {
        view.printGameStarted();
        int currentNumber;
        while (true) {
            view.printInputNumber();
            if (!sc.hasNextInt()) {
                view.printWrongInput();
                sc.next();
                continue;
            }
            currentNumber = sc.nextInt();

            if (currentNumber == numberToGuess) {
                model.changeModel(currentNumber);
                break;
            }

            view.printMismatch();

            if (currentNumber > model.getHighBound()
                    || currentNumber < model.getLowBound()) {
                view.printOutOfRange();
            } else if (currentNumber > numberToGuess) {
                view.printLess();
            } else if (currentNumber < numberToGuess) {
                view.printGreater();
            }

            model.changeModel(currentNumber);
            view.printCurrentLog(model);


        }

        view.printResult(model);

    }


    public void initializeGame(Scanner sc) {
        while (true) {
            view.printStartGame();
            if (!sc.hasNextInt()) {
                view.printWrongInput();
                sc.next();
                continue;
            }

            int gameType = sc.nextInt();

            switch (gameType) {
                case TYPE_ONE:
                    numberToGuess = model.rand();
                    break;
                case TYPE_TWO:
                    numberToGuess = manualBoundsInput(sc);
                    break;
                default:
                    view.printWrongInput();
                    continue;
            }
            break;
        }

    }

    public int manualBoundsInput(Scanner sc) {

        view.printInputLowBound();
        int low = sc.nextInt();

        while (!model.checkLowBound(low)) {
            view.printWrongInput();
            low = sc.nextInt();
        }
        model.setLowBoundAtStart(low);

        view.printInputHighBound(model);
        int high = sc.nextInt();

        while (!model.checkHighBound(high)) {
            view.printWrongInput();
            view.printInputHighBound(model);
            high = sc.nextInt();
        }
        model.setHighBoundAtStart(high);

        return model.rand(low, high);

    }


}
