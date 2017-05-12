package com.petro.game;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        GameModel gModel = new GameModel();
        GameView gView = new GameView();
        new GameController(gModel,gView).run();
    }

}
