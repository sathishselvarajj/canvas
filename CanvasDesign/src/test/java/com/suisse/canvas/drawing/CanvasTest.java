package com.suisse.canvas.drawing;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CanvasTest {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	
	@Test
	public void inCorrectInput1() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Not a valid Input to create Canvas");
		Canvas canvas = new Canvas("C 20 ");
		canvas.createCanvas();
	}
	
	@Test
	public void inCorrectInput2() throws Exception {
		thrown.expect(NumberFormatException.class);
		Canvas canvas = new Canvas("C 20 g");
		canvas.createCanvas();
	}
	
	@Test
	public void inCorrectInput3() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Canvas coordinates has to be positive");
		Canvas canvas = new Canvas("C 20 -4");
		canvas.createCanvas();
	}
	
	@Test
	public void createCanvas() throws Exception {	
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		char [][] drawingBoard = canvas.getDrawingBoard();
		
		char[][] drawingBoardExpected = {{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
		Assert.assertEquals(6, drawingBoard.length);
		Assert.assertEquals(22, drawingBoard[0].length);
		Assert.assertArrayEquals(drawingBoardExpected, drawingBoard);
	}
	
	@Test
	public void isPointInRange() throws Exception {	
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		Point point1 = new Point();
		point1.setLocation(2, 22);
		Assert.assertEquals(false, canvas.isPointInRange(point1));
		
		Point point2 = new Point();
		point2.setLocation(6, 10);
		Assert.assertEquals(false, canvas.isPointInRange(point2));
		
		Point point3 = new Point();
		point3.setLocation(3, 10);
		Assert.assertEquals(true, canvas.isPointInRange(point3));
	}

}
