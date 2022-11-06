package Model;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public Circle( Color color, int radius, int xCenter, int yCenter, boolean filled) {

        super(color, xCenter, yCenter, filled);
        this.radius = radius;
        setUpBoundingBox();
    }

    @Override
    public void drawShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int diameter = radius * 2;
        g2d.setColor(color);
        if(filled == false){
        g2d.drawOval(this.xCenter - radius, this.yCenter - radius, diameter, diameter);
    }else if(filled) {
            g2d.fillOval(this.xCenter - radius, this.yCenter - radius, diameter, diameter);
        }}

    @Override
    public void drawBoundingBox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.lightGray);
        g2d.drawRect(bb.getBotLeft().getX(), bb.getTopRight().getY(), (bb.getTopRight().getX()-xCenter)*2, (bb.getBotLeft().getY()-yCenter)*2);
    }

    @Override
    public void drawSimpleName(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawString(this.getClass().getSimpleName(),xCenter, yCenter);
    }

    @Override
    public void drawShapeConsole() {
        System.out.println(this.toString());
    }

    @Override
    public void setUpBoundingBox() {
        Point botLeft = new Point(xCenter - radius, yCenter + radius);
        Point topRight = new Point(xCenter + radius,  yCenter - radius);
        bb = new BoundingBox(botLeft, topRight);
    }

    @Override
    public String toString() {
        return "Circle{"
                + "radius= " + radius + ", "
                + super.toString();
    }
}
