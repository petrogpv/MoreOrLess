package com.petro.game.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 14.05.2017.
 */
public class ModelTest {
    @Test
    public void testRandAuto() throws Exception {
            Model model = new Model();
        int numberToGuess = 0;
        for (int i = 0; i < 100; i++) {
            numberToGuess = model.rand();
            assertTrue(numberToGuess >= model.LOW_BOUND_DEFAULT);
            assertTrue(numberToGuess <= model.HIGH_BOUND_DEFAULT);
        }
    }

    @Test
    public void testRandManual() throws Exception {
        Model model = new Model();
        int numberToGuess = model.rand(10,20);
        assertTrue(numberToGuess >= 10);
        assertTrue(numberToGuess <= 20);
    }


    @Test
    public void checkOutOfRangeNoBoundsChange() throws Exception {
        Model model = new Model();
        model.rand();
        int lowBound = model.getLowBound();
        int highBound = model.getHighBound();
        model.changeModel(lowBound - 1);
        model.changeModel(highBound + 1);
        assertTrue(lowBound == model.getLowBound());
        assertTrue(highBound == model.getHighBound());
    }

    @Test
    public void checkBoundsChange() throws Exception {
        Model model = new Model();
        model.rand(10,20);
        model.setNumberToGuess(15);
        int lowBound = model.getLowBound();
        int highBound = model.getHighBound();
        model.changeModel(lowBound + 1);
        model.changeModel(highBound - 1);
        assertTrue(lowBound != model.getLowBound());
        assertTrue(highBound != model.getHighBound());

    }

}