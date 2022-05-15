package com.cs.canvas.factory;


public interface IShape {
    char INK_COLOR = 'x';
    String SPACE_DELIMITER = " ";
    String TYPE_CANVAS = "C";
    char TYPE_LINE = 'L';
    char TYPE_RECTANGLE = 'R';
    char TYPE_BUCKETFILL = 'B';

    void createShape() throws Exception;
}
