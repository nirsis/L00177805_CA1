package Model;

import java.awt.*;

public class BoundingBox {

    public Point getBotLeft() {
        return botLeft;
    }

    public void setBotLeft(Point botLeft) {
        this.botLeft = botLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    private Point botLeft;
    private Point topRight;

    public BoundingBox(Point botLeft, Point topRight) {
        this.botLeft = botLeft;
        this.topRight = topRight;

    }

}

