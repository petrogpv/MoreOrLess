package com.petro.game;

import com.petro.game.model.Model;
import com.petro.game.view.View;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        new Controller(model, view).run();
    }

}
