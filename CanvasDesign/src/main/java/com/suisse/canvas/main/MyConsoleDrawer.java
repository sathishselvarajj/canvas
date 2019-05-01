package com.suisse.canvas.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.suisse.canvas.drawing.Canvas;
import com.suisse.canvas.factory.IShape;
import com.suisse.canvas.factory.ShapeFactory;

public class MyConsoleDrawer {

	public static final String I_QUIT = "quit";
	
    List<Canvas> canvasList = new ArrayList<Canvas>();

    /**
     * 
     * @param args
     * @throws IOException
     */
	public static void main(final String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		MyConsoleDrawer main = new MyConsoleDrawer();
		while (true) {

			System.out.print("Please enter the command: ");
			String userInput = scanner.nextLine();

			if (I_QUIT.length() == userInput.length() && I_QUIT.equals(userInput.toLowerCase())) {
				System.out.println("Quiting.....");
				scanner.close();
				return;
			}
			try {
				main.parseInput(userInput);
			}
			catch(NumberFormatException e) {
				System.out.println("Sorry!.. Coordinates must be integers....");	
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public void parseInput(String input) throws Exception {
		
		//check if the input is null or empty..
		if(input == null || input.trim().isEmpty())
			throw new Exception("Input is Null or Empty. Please enter something!!");

		//split the input into String array with delimiter as space
		String[] inputTypes = input.trim().split(IShape.SPACE_DELIMITER);

		if (inputTypes.length > 0 && !inputTypes[0].isEmpty() && inputTypes[0].length() == 1) {

			if (IShape.TYPE_CANVAS.equalsIgnoreCase(inputTypes[0])) {
				Canvas canvas = new Canvas(input);
				canvas.createCanvas();
				canvasList.add(canvas);
			} else if (canvasList.size() > 0) {
				IShape shape = ShapeFactory.getShape(inputTypes[0].toUpperCase().charAt(0), input, canvasList.get(canvasList.size() - 1));
				shape.createShape();
			} else {
				throw new Exception("No canvas available. Please create one before drawing shapes..");
			}
		} else {
			throw new Exception("Not a valid Input.");
		}
		for (Canvas canvas : canvasList) {
			char[][] drawingBoard = canvas.getDrawingBoard();
			for (int i = 0; i < drawingBoard.length; i++) {
				for (int j = 0; j < drawingBoard[0].length; j++) {
					System.out.print(drawingBoard[i][j]);
				}
				System.out.println();
			}
		}
	}

}
