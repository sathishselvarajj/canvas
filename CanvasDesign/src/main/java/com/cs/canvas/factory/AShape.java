package com.cs.canvas.factory;


public abstract class AShape implements IShape {

    public void createShape() throws Exception {
        validate();
        draw();
    }

    public abstract void validate() throws Exception;

    public abstract void draw() throws Exception;

}
