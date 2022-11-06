package Model;

import View.Consts;

import java.awt.*;

public class Quadrilateral extends Shape implements Rotatable {

    protected Point[] pointArray;
    protected Point center;
    protected int xmin = Consts.FRAME_WIDTH;
    protected int xmax = 0;
    protected int ymin = Consts.FRAME_HEIGHT;
    protected int ymax = 0;

    public Quadrilateral(Color color, Point center, Point[] points, boolean filled) {
        super(center.getX(), center.getY(), filled);
        this.center = center;
        this.pointArray = points;
        setUpBoundingBox();
    }

    public Quadrilateral(Color color, Point center, Point p1, Point p2, Point p3, Point p4, boolean filled) {
        super(center.getX(), center.getY(), filled);
        this.center = center;
        this.pointArray = new Point[4];
        pointArray[0] = p1;
        pointArray[1] = p2;
        pointArray[2] = p3;
        pointArray[3] = p4;
        setUpBoundingBox();
    }

    public Quadrilateral(Rectangle rect) {
        super(rect.xCenter, rect.yCenter, rect.filled);
        this.pointArray = new Point[4];
        Point bleft = new Point(xCenter - (rect.width / 2), yCenter + (rect.height / 2));
        Point tright = new Point(xCenter + (rect.width / 2), yCenter - (rect.height / 2));
        Point bright = new Point(xCenter + (rect.width / 2), yCenter + (rect.height / 2));
        Point tleft = new Point(xCenter - (rect.width / 2), yCenter - (rect.height / 2));
        pointArray[0] = bleft;
        pointArray[1] = bright;
        pointArray[2] = tright;
        pointArray[3] = tleft;
        setUpBoundingBox();
    }


    @Override
    public void rotateNinetyDegrees() {

    }

    @Override
    public void drawShape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        int[] x = new int[pointArray.length];

        for (int i = 0; i < pointArray.length; i++) {

            x[i] = pointArray[i].getX();

        }
        int[] y = new int[pointArray.length];

        for (int i = 0; i < pointArray.length; i++) {

            y[i] = pointArray[i].getY();

        }
        if (filled) {
            g2d.fillPolygon(x, y, pointArray.length);
        } else if (!filled) {
            g2d.drawPolygon(x, y, pointArray.length);
        }

    }

    @Override
    public void drawBoundingBox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.lightGray);
        g2d.drawRect(xmax - (xmax - xmin), ymax - (ymax - ymin), bb.getTopRight().getX() - bb.getBotLeft().getX(), bb.getBotLeft().getY() - bb.getTopRight().getY());
    }


    @Override
    public void setUpBoundingBox() {


        for (int i = 0; i < pointArray.length; ++i) {
            if (pointArray[i].getX() < xmin)
                xmin = pointArray[i].getX();

            if (pointArray[i].getY() < ymin)
                ymin = pointArray[i].getY();

            if (pointArray[i].getX() > xmax)
                xmax = pointArray[i].getX();

            if (pointArray[i].getY() > ymax)
                ymax = pointArray[i].getY();
        }

        Point topright = new Point(xmax, ymin);
        Point botleft = new Point(xmin, ymax);
        bb = new BoundingBox(botleft, topright);
    }

    @Override
    public void drawSimpleName(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawString(this.getClass().getSimpleName(), xCenter, yCenter);
    }
}
