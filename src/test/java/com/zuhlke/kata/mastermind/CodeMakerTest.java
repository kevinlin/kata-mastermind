package com.zuhlke.kata.mastermind;

import static com.zuhlke.kata.mastermind.Color.BLACK;
import static com.zuhlke.kata.mastermind.Color.WHITE;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CodeMakerTest {

    private CodeMaker codeMaker;

    @Test
    public void feedback_allExactMatch() {
        codeMaker = new CodeMaker(BLACK, BLACK, BLACK, BLACK);
        assertArrayEquals(new int[]{4, 0}, codeMaker.feedback(BLACK, BLACK, BLACK, BLACK));
    }

    @Test
    public void feedback_noMatchAtAll() {
        codeMaker = new CodeMaker(BLACK, BLACK, BLACK, BLACK);
        assertArrayEquals(new int[]{0, 0}, codeMaker.feedback(WHITE, WHITE, WHITE, WHITE));
    }

    @Test
    public void feedback_noExactMatchWithAllColorMatch() {
        codeMaker = new CodeMaker(BLACK, BLACK, WHITE, WHITE);
        assertArrayEquals(new int[]{0, 4}, codeMaker.feedback(WHITE, WHITE, BLACK, BLACK));
    }

    @Test
    public void feedback_colorMatchWithExactCount() {
        codeMaker = new CodeMaker(BLACK, BLACK, WHITE, WHITE);
        assertArrayEquals(new int[]{3, 0}, codeMaker.feedback(BLACK, BLACK, BLACK, WHITE));
    }

    @Test
    public void feedback_colorMatchOnlyConsiderUnmatchedPosition() {
        codeMaker = new CodeMaker(BLACK, BLACK, WHITE, WHITE);
        assertArrayEquals(new int[]{3, 0}, codeMaker.feedback(BLACK, WHITE, WHITE, WHITE));
    }

    @Test
    public void feedback_colorMatchOnlyConsiderUnmatchedPositionWithExactCount() {
        codeMaker = new CodeMaker(BLACK, BLACK, BLACK, WHITE);
        assertArrayEquals(new int[]{1, 2}, codeMaker.feedback(BLACK, WHITE, WHITE, BLACK));
    }

}