package com.suisse.canvas.factory;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.suisse.canvas.shapes.BucketFill;
import com.suisse.canvas.shapes.Line;
import com.suisse.canvas.shapes.Rectangle;


public class ShapesFactoryTest {
	
	@Test
	public void getShape() throws Exception {
		
		IShape line = ShapeFactory.getShape('L', null, null);	
		Assert.assertTrue(line instanceof Line);
		
		IShape rectangle = ShapeFactory.getShape('R', null, null);	
		Assert.assertTrue(rectangle instanceof Rectangle);
		
		IShape bucketFill = ShapeFactory.getShape('B', null, null);	
		Assert.assertTrue(bucketFill instanceof BucketFill);
	}
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void inputCorrectInput() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("No such shape supported...");
		ShapeFactory.getShape('S', null, null);
	}

}
