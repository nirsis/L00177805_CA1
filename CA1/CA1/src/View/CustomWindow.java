package View;

import Model.ShapesManager;

import javax.swing.*;
import java.awt.*;

/**
 * We can think of a JFrame as a window
 * By extending (inheriting from) the class javax.swing.JFrame we can
 * define what goes into our window - in this case a single JPanel which is
 * a component container for GUI elements.
 */
public class CustomWindow extends JFrame {

    private CustomPanel customPanel;

    public CustomWindow(ShapesManager sm) {
        customPanel = new CustomPanel(sm);

        //add our new panel to the frame
        add(customPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);


    }


}
