package com.cs.canvas.factory;

import com.cs.canvas.drawing.Canvas;
import com.cs.canvas.shapes.BucketFill;
import com.cs.canvas.shapes.Line;
import com.cs.canvas.shapes.Rectangle;

public class ShapeFactory {

    private ShapeFactory() {
    }

    public static IShape getShape(char shape, String input, Canvas canvas) throws Exception {

        IShape returnShape = null;

        switch (shape) {
            case IShape.TYPE_LINE:
                returnShape = new Line(input, canvas);
                break;
            case IShape.TYPE_RECTANGLE:
                returnShape = new Rectangle(input, canvas);
                break;
            case IShape.TYPE_BUCKETFILL:
                returnShape = new BucketFill(input, canvas);
                break;
            default:
                throw new Exception("No such shape supported...");
        }
        return returnShape;
    }

}
