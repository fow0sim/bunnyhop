package eu.simmig.bunnyhop;

import javax.swing.*;
import java.awt.*;

public class BunnyHopScreen {
    JFrame frame;
    JPanel canvas;
    BunnyHopParser parser;

    public void run() {
        frame = new JFrame("Bunny Hop");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        canvas = new JPanel();
        frame.add(canvas);
        frame.setPreferredSize(new Dimension(width/2, height/2));
        frame.setLocation(width/4, height/4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        paintQRCode();
    }

    public void paintQRCode() {
        parser = new BunnyHopParser();
        parser.parse("bunnyhop.txt");
        int[][] code = parser.getArray();

    }
}
