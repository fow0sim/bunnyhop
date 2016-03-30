package eu.simmig.bunnyhop;

import javax.swing.*;
import java.awt.*;

public class BunnyHopScreen {
    JFrame frame;

    public void run() {
        frame = new JFrame("Bunny Hop");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setPreferredSize(new Dimension(width/2, height/2));
        frame.setLocation(width/4, height/4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
