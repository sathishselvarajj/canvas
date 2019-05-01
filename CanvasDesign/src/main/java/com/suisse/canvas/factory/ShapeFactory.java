package com.suisse.canvas.factory;

import com.suisse.canvas.drawing.Canvas;
import com.suisse.canvas.shapes.Line;
import com.suisse.canvas.shapes.Rectangle;
import com.suisse.canvas.shapes.BucketFill;

public class ShapeFactory {

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

	private ShapeFactory() {
	}

}
