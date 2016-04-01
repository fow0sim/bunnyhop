package eu.simmig.bunnyhop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class QRCodeScreen extends JPanel implements ComponentListener {
    private int[][] qrCode;

    public QRCodeScreen(int[][] qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int scale = (width - 2) / qrCode[0].length;
        scale = Math.min(scale, (height - 2) / qrCode.length);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        for (int i = 0; i < qrCode.length; i += 1) {
            for (int j = 0; j < qrCode[0].length; j += 1) {
                if (qrCode[i][j] == 1) {
                    g.fillRect((j + 1) * scale, (i + 1) * scale, scale, scale);
                }
            }
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
