package Control;

import Model.*;

import Model.Point;
import Model.Rectangle;
import View.CustomWindow;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {



    public Display() {

        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(true);
        shapesManager.addShape(new Circle(Color.blue,50, 50, 50, true ));
        shapesManager.addShape(new Rectangle(Color.red, 200, 50, 100, 50, true ));
        shapesManager.addShape(new Quadrilateral(Color.red, new Point(365,250),new Point[] {new Point(360,210),new Point(490, 220), new Point(480, 300), new Point(350, 300)}, true));
        shapesManager.addShape(new Quadrilateral(Color.blue, new Point (250,300),new Point (260,250) ,new Point (310,250),new Point (300,320),new Point (270,300), true));
        Rectangle rect = new Rectangle(Color.MAGENTA, 100, 350, 75, 60, false);
        shapesManager.addShape(new Quadrilateral(rect));
        shapesManager.addShape(new Square(Color.CYAN, 450, 350, true, 80));
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Testing CA1");
        customWindow.setVisible(true);



    }



    public static void main(String[] args) {
        new Display();


    }
}