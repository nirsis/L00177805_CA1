package View;

import Model.BoundingBox;
import Model.Point;
import Model.Shape;
import Model.ShapesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class CustomPanel extends JPanel {
    private ShapesManager sm = new ShapesManager();

    public CustomPanel(ShapesManager sm) {
        this.sm = sm;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                for (Shape currShape : getIntersectingShapes(e)) {

                    currShape.setFilled(!currShape.isFilled());
                    repaint();
                }

            }
        });
    }

    private ArrayList<Shape> getIntersectingShapes(MouseEvent e) {
        ArrayList<Shape> intersectingShapes = new ArrayList<>();
        for (Shape currShape : sm.getShapes()) {
            if (inBounds(currShape.getBb(), new Point(e.getX(), e.getY()))) {
                intersectingShapes.add(currShape);
            }
        }

        return intersectingShapes;
    }

    private boolean inBounds(BoundingBox bb, Point p) {
        boolean toReturn;
        if(p.getX()>= bb.getBotLeft().getX() && p.getX() <= bb.getTopRight().getX() && p.getY() >= bb.getTopRight().getY() && p.getY() <= bb.getBotLeft().getY() ){
            toReturn = true;
        }else {
            toReturn = false;
        }
        return toReturn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.

        super.paintComponent(g);
        sm.drawShapes(g);
        sm.drawBoundingBoxes(g);
        sm.drawSimpleNames(g);

    }


}
