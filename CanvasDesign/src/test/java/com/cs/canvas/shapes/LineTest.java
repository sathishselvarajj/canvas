package com.cs.canvas.shapes;

import com.cs.canvas.drawing.Canvas;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LineTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShape() throws Exception {
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Line line = new Line("L 1 2 6 2", canvas);
        line.createShape();
        char[][] drawingBoard = canvas.getDrawingBoard();

        char[][] drawingBoardExpected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
        Assert.assertEquals(6, drawingBoard.length);
        Assert.assertEquals(22, drawingBoard[0].length);
        Assert.assertArrayEquals(drawingBoardExpected, drawingBoard);
    }

    @Test
    public void incorrectInput1() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Not a valid Input to create Line");
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Line line = new Line("L 1 2 6 2 5", canvas);
        line.createShape();

    }

    @Test
    public void incorrectInput2() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Currently only horizontal and vertical lines are supported");
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Line line = new Line("L 1 2 6 5", canvas);
        line.createShape();

    }


    @Test
    public void incorrectInput3() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Line can only be created within canvas limits");
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Line line = new Line("L 1 2 22 2", canvas);
        line.createShape();

    }

}
