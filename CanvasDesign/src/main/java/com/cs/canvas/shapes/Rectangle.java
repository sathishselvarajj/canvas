package com.cs.canvas.shapes;

import com.cs.canvas.drawing.Canvas;
import com.cs.canvas.factory.AShape;

import java.awt.*;


public class Rectangle extends AShape {

    private final String input;
    private final Canvas canvas;
    private Point point1;
    private Point point2;

    public Rectangle(String input, Canvas canvas) {
        this.input = input;
        this.canvas = canvas;
    }

    public void draw() throws Exception {

        char[][] drawingBoard = canvas.getDrawingBoard();

        for (int j = minNumber(point1.y, point2.y); j <= maxNumber(point1.y, point2.y); j++) {
            drawingBoard[point1.x][j] = INK_COLOR;
            drawingBoard[point2.x][j] = INK_COLOR;
        }

        for (int j = minNumber(point1.x, point2.x) + 1; j < maxNumber(point1.x, point2.x); j++) {
            drawingBoard[j][point1.y] = INK_COLOR;
            drawingBoard[j][point2.y] = INK_COLOR;

        }

    }

    public int minNumber(int x, int y) {

        if (x < y)
            return x;
        else
            return y;
    }

    public int maxNumber(int x, int y) {

        if (x > y)
            return x;
        else
            return y;
    }

    @Override
    public void validate() throws Exception {
        String[] split = input.split(SPACE_DELIMITER);

        if (split.length != 5)
            throw new Exception("Not valid Input to create Rectangle");

        point1 = new Point(Integer.parseInt(split[2]), Integer.parseInt(split[1]));
        point2 = new Point(Integer.parseInt(split[4]), Integer.parseInt(split[3]));

        if (!canvas.isPointInRange(point1) || !canvas.isPointInRange(point2))
            throw new Exception("Rectangle can only be created within canvas limits");

    }

}
