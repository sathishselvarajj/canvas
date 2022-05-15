package com.cs.canvas.shapes;

import com.cs.canvas.drawing.Canvas;
import com.cs.canvas.factory.AShape;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFill extends AShape {

    public static int BUCKETFILL_INPUT_LENGTH = 4;
    public static int COLOR_CHAR_LENGTH = 1;
    private final String input;
    private final Canvas canvas;
    private Point point;
    private char color;

    public BucketFill(String input, Canvas canvas) {
        this.input = input;
        this.canvas = canvas;
    }

    public void draw() throws Exception {

        char[][] drawingBoard = canvas.getDrawingBoard();

        colorFill(drawingBoard, point.x, point.y, color);
    }

    private void colorFill(char[][] drawingBoard, int x, int y, char color) {

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            if (colorFillDo(drawingBoard, p.x, p.y, color)) {
                queue.add(new Point(p.x, p.y - 1));
                queue.add(new Point(p.x, p.y + 1));
                queue.add(new Point(p.x - 1, p.y));
                queue.add(new Point(p.x + 1, p.y));
            }
        }
    }

    private boolean colorFillDo(char[][] drawingBoard, int x, int y, char color) {
        if (x < 1 || x > drawingBoard.length - 2 || y < 1 || y > drawingBoard[0].length - 2)
            return false;
        if (INK_COLOR == drawingBoard[x][y])
            return false;
        if (color == drawingBoard[x][y])
            return false;
        drawingBoard[x][y] = color;
        return true;
    }

    @Override
    public void validate() throws Exception {
        String[] split = input.split(SPACE_DELIMITER);

        if (split.length != BUCKETFILL_INPUT_LENGTH)
            throw new Exception("Not a valid Input to fill color");

        point = new Point(Integer.parseInt(split[2]), Integer.parseInt(split[1]));
        if (!canvas.isPointInRange(point))
            throw new Exception("Can fill color within canvas limits");

        if (split[3].length() > COLOR_CHAR_LENGTH)
            throw new Exception("Color has to be single character");

        color = split[3].charAt(0);

        if (INK_COLOR == color)
            throw new Exception("Fill color cant be Ink color");
    }
}
