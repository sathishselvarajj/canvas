package com.cs.canvas.factory;

import com.cs.canvas.shapes.BucketFill;
import com.cs.canvas.shapes.Line;
import com.cs.canvas.shapes.Rectangle;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ShapesFactoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getShape() throws Exception {

        IShape line = ShapeFactory.getShape('L', null, null);
        Assert.assertTrue(line instanceof Line);

        IShape rectangle = ShapeFactory.getShape('R', null, null);
        Assert.assertTrue(rectangle instanceof Rectangle);

        IShape bucketFill = ShapeFactory.getShape('B', null, null);
        Assert.assertTrue(bucketFill instanceof BucketFill);
    }

    @Test
    public void inputCorrectInput() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("No such shape supported...");
        ShapeFactory.getShape('S', null, null);
    }

}
