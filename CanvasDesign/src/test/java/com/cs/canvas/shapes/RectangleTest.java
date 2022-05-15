package com.cs.canvas.shapes;

import com.cs.canvas.drawing.Canvas;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShape() throws Exception {
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Rectangle rectangle = new Rectangle("R 14 1 18 3", canvas);
        rectangle.createShape();
        char[][] drawingBoard = canvas.getDrawingBoard();

        char[][] drawingBoardExpected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
        Assert.assertEquals(6, drawingBoard.length);
        Assert.assertEquals(22, drawingBoard[0].length);
        Assert.assertArrayEquals(drawingBoardExpected, drawingBoard);
    }

    @Test
    public void incorrectInput1() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Not valid Input to create Rectangle");
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Rectangle rectangle = new Rectangle("R 1 2 6 5 6", canvas);
        rectangle.createShape();

    }

    @Test
    public void incorrectInput2() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Rectangle can only be created within canvas limits");
        Canvas canvas = new Canvas("C 20 4");
        canvas.createCanvas();
        Rectangle rectangle = new Rectangle("R 1 2 25 5 ", canvas);
        rectangle.createShape();

    }

}
