package com.cs.canvas.main;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RunMeToDrawCanvasTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void parseInput() throws Exception {

        RunMeToDrawCanvas main = new RunMeToDrawCanvas();
        main.parseInput("C 20 4");

        char[][] drawingBoard = main.canvasList.get(0).getDrawingBoard();

        char[][] drawingBoardExpected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
        Assert.assertEquals(6, drawingBoard.length);
        Assert.assertEquals(22, drawingBoard[0].length);
        Assert.assertArrayEquals(drawingBoardExpected, drawingBoard);
    }

    @Test
    public void incorrectInputNull() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Input is Null or Empty. Please enter something!!");
        RunMeToDrawCanvas main = new RunMeToDrawCanvas();
        main.parseInput(null);
    }

    @Test
    public void incorrectInputEmpty() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Input is Null or Empty. Please enter something!!");
        RunMeToDrawCanvas main = new RunMeToDrawCanvas();
        main.parseInput(" ");
    }

    @Test
    public void incorrectInput1() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("No canvas available. Please create one before drawing shapes..");
        RunMeToDrawCanvas main = new RunMeToDrawCanvas();
        main.parseInput("L 24 22");
    }

    @Test
    public void incorrectInput2() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Not a valid Input");
        RunMeToDrawCanvas main = new RunMeToDrawCanvas();
        main.parseInput("LR 24 22");
    }

}
