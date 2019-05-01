package com.suisse.canvas.factory;


public interface IShape {
	char INK_COLOR = 'x';
	String SPACE_DELIMITER = " ";
	String TYPE_CANVAS = "C";
	char TYPE_LINE = 'L';
	char TYPE_RECTANGLE = 'R';
	char TYPE_BUCKETFILL = 'B';
	
	public void createShape() throws Exception;
}
