package com.suisse.canvas.drawing;

import java.awt.Point;

import com.suisse.canvas.factory.IShape;

public class Canvas {

	public static final char HORIZONTAL_BORDER = '-';
	public static final char VERTICAL_BORDER = '|';
	public static final char CANVAS_FILL = ' ';

	private char[][] drawingBoard;
	private String input;
	private Point point;

	public char[][] getDrawingBoard() {
		return drawingBoard;
	}

	public void setDrawingBoard(char[][] drawingBoard) {
		this.drawingBoard = drawingBoard;
	}

	public char[][] createCanvas() throws Exception {
		isInputValid();

		for (int i = 0; i <= point.x + 1; i++) {
			for (int j = 0; j <= point.y + 1; j++) {

				if (i == 0 || i > point.x) {
					drawingBoard[i][j] = HORIZONTAL_BORDER;
				} else if (j == 0 || j > point.y) {
					drawingBoard[i][j] = VERTICAL_BORDER;
				} else {
					drawingBoard[i][j] = CANVAS_FILL;
				}

			}
		}
		return drawingBoard;
	}

	public Canvas(String input) {
		this.input = input;
	}

	public void isInputValid() throws Exception {
		String[] split = input.split(IShape.SPACE_DELIMITER);

		if (split.length != 3)
			throw new Exception("Not a valid Input to create Canvas");

		int x = Integer.parseInt(split[2]);
		int y = Integer.parseInt(split[1]);
		
		if (x<1 || y<1)
			throw new Exception("Canvas coordinates has to be positive");
		
		drawingBoard = new char[x + 2][y + 2];
		point = new Point();
		point.setLocation(x, y);
	}

	public boolean isPointInRange(Point inputPoint) {

		if (inputPoint.x > 0 && inputPoint.x <= point.x && inputPoint.y > 0 && inputPoint.y <= point.y) {
			return true;
		} else
			return false;
	}

}
