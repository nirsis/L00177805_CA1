package Model;

import java.awt.*;

public abstract class Shape {
    /**
     * Abstract class that contains the initial parameters for a Shape
     */
    protected Color color;
    protected Boolean filled;
    protected int xCenter;
    protected int yCenter;

    public BoundingBox getBb() {
        return bb;
    }

    public void setBb(BoundingBox bb) {
        this.bb = bb;
    }

    protected BoundingBox bb;



    Shape(Color color, int xCenter, int yCenter, boolean filled) {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.filled = filled;

    }
    Shape(int xCenter, int yCenter, boolean filled) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.filled = filled;
    }

    public boolean isFilled() {

        return filled;
    }

    public void setFilled(boolean filled) {

        this.filled = filled;
    }

    @Override
    public String toString() {
        return "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public abstract void drawShape(Graphics g);

    public abstract void drawBoundingBox(Graphics g);

    public abstract void drawSimpleName(Graphics g);
    public abstract void setUpBoundingBox();

    public void drawShapeConsole() {
        System.out.println(this.toString());
    }
}
