package eu.simmig.bunnyhop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class BunnyHopScreen {
    JFrame frame;
    QRCodeScreen qrCodeScreen;
    BunnyHopParser parser;

    public BunnyHopScreen() {
        loadQRCode("bunnyhop.txt");
    }

    public void run() {
        frame = new JFrame("Bunny Hop");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        qrCodeScreen = new QRCodeScreen(parser.getArray());
        frame.add(qrCodeScreen);
        frame.setPreferredSize(new Dimension(width/2, height/2));
        frame.setLocation(width/4, height/4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void loadQRCode(String fileName) {
        parser = new BunnyHopParser();
        parser.parse(fileName);
    }
}
