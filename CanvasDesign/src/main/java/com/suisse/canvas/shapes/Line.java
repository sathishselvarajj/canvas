package com.suisse.canvas.shapes;

import java.awt.Point;

import com.suisse.canvas.drawing.Canvas;
import com.suisse.canvas.factory.AShape;

public class Line extends AShape {
	
	public static int LINE_INPUT_LENGTH = 5;
	
	private String input;
	private Canvas canvas;
	
	private Point point1;
	private Point point2;

	public void draw() throws Exception {
		
		char[][] drawingBoard = canvas.getDrawingBoard();

		if (point1.x == point2.x) {

			for (int j = minNumber(point1.y, point2.y); j <= maxNumber(point1.y, point2.y); j++) {
				drawingBoard[point1.x][j] = INK_COLOR;
			}

		} else if (point1.y == point1.y) {

			for (int j = minNumber(point1.x, point2.x); j <= maxNumber(point1.x, point2.x); j++) {
				drawingBoard[j][point1.y] = INK_COLOR;

			}

		} 

	}
	
	public int minNumber(int x, int y) {
		
		if(x<y)
			return x;
		else
			return y;
	}
	public int maxNumber(int x, int y) {
		
		if(x>y)
			return x;
		else
			return y;
	}

	public Line(String input, Canvas canvas) {
		this.input = input;
		this.canvas = canvas;
	}

	@Override
	public void validate() throws Exception {
		String[] split = input.split(SPACE_DELIMITER);
		
		if(split.length != LINE_INPUT_LENGTH)
			throw new Exception("Not a valid Input to create Line");
		
		point1 = new Point(Integer.parseInt(split[2]), Integer.parseInt(split[1]));
		point2 = new Point(Integer.parseInt(split[4]), Integer.parseInt(split[3]));
         
         if (!(point1.x == point2.x || point1.y == point2.y))
        	 throw new Exception("Currently only horizontal and vertical lines are supported");
         
         if(!canvas.isPointInRange(point1) || !canvas.isPointInRange(point2))
        	 throw new Exception("Line can only be created within canvas limits");
		
	}
}
