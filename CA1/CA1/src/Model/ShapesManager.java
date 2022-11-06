package Model;

import java.awt.*;
import java.util.ArrayList;

public class ShapesManager {


    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private boolean displayName = true;
    private boolean displayBoundingBox = true;


    public void addShape(Shape shape) {

        shapes.add(shape);

    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }
    public void drawShapes(Graphics g) {

        for (Shape currShape : shapes) {
            currShape.drawShape(g);
        }
    }
    public void drawBoundingBoxes(Graphics g) {
        if(displayBoundingBox) {
            for (Shape currShape : shapes) {
                currShape.drawBoundingBox(g);
            }
        }    }
    public void drawSimpleNames(Graphics g) {
        if(displayName) {
            for (Shape currShape : shapes) {
                currShape.drawSimpleName(g);
            }
        }    }
    public boolean isDisplayName() {
        return displayName;
    }

    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    public boolean isDisplayBoundingBox() {
        return displayBoundingBox;
    }

    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }

}
