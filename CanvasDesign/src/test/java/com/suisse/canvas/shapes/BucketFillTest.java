package com.suisse.canvas.shapes;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.suisse.canvas.drawing.Canvas;

public class BucketFillTest {
	
	
	@Test
	public void createShape() throws Exception {	
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		Rectangle rectangle = new Rectangle("R 14 1 18 3", canvas);
		rectangle.createShape();	
		BucketFill bucketFill = new BucketFill("B 15 2 g", canvas);
		bucketFill.createShape();
		
		char [][] drawingBoard = canvas.getDrawingBoard();
		
		char[][] drawingBoardExpected = {{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','x','x','x','x','x',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','x','g','g','g','x',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','x','x','x','x','x',' ',' ','|'},
				{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
		Assert.assertEquals(6, drawingBoard.length);
		Assert.assertEquals(22, drawingBoard[0].length);
		Assert.assertArrayEquals(drawingBoardExpected, drawingBoard);
	}
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	
	@Test
	public void incorrectInput1() throws Exception {
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Not a valid Input to fill color");
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		BucketFill bucketFill = new BucketFill("B 15 2 32 23", canvas);
		bucketFill.createShape();

	}
	
	@Test
	public void incorrectInput2() throws Exception {
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Can fill color within canvas limits");
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		BucketFill bucketFill = new BucketFill("B 22 2 g", canvas);
		bucketFill.createShape();

	}
	
	@Test
	public void incorrectInput3() throws Exception {
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Color has to be single character");
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		BucketFill bucketFill = new BucketFill("B 15 2 32", canvas);
		bucketFill.createShape();

	}
	
	@Test
	public void incorrectInput4() throws Exception {
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Fill color cant be Ink color");
		Canvas canvas = new Canvas("C 20 4");
		canvas.createCanvas();	
		BucketFill bucketFill = new BucketFill("B 15 2 x", canvas);
		bucketFill.createShape();

	}

}
