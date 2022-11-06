package Model;

import java.awt.*;

public class Rectangle extends Shape implements Moveable {

    protected int width;
    protected int height;

    public Rectangle(Color color, int xCenter, int yCenter, int width, int height, boolean filled) {
        super(color, xCenter, yCenter, filled);
        this.width = width;
        this.height = height;
        setUpBoundingBox();

    }

    @Override
    public void drawShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        if (filled == false) {
            g2d.drawRect(this.xCenter, this.yCenter, this.width, this.height);
        } else if (filled == true) {
            g2d.fillRect(this.xCenter, this.yCenter, this.width, this.height);
        }

    }

    @Override
    public void drawBoundingBox(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.lightGray);
        g2d.drawRect(xCenter, yCenter, width, height);
    }

    @Override
    public void drawSimpleName(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawString(this.getClass().getSimpleName(),xCenter, yCenter);
    }


    @Override
    public void setUpBoundingBox() {

        Point botLeft = new Point(this.xCenter , this.yCenter+height);
        Point topRight = new Point(this.xCenter+width  , this.yCenter  );
        bb = new BoundingBox(botLeft, topRight);

    }

    @Override
    public void moveTenUnits() {

    }
}
