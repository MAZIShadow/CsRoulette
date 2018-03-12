package org.home.mazi.csroulette.view;

import org.home.mazi.csroulette.model.RouletteResult;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JRouletteResultPanel extends JPanel {

    private RouletteResult rouletteResult;
    private String debugText;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (rouletteResult == null) {
            return;
        }

        printImage(g, rouletteResult.getImage(), this);
        printHeadline(g, rouletteResult.getName(), this);
        printDescription(g, rouletteResult.getDescription(), this);
        //printDebugText(g);
    }

    public void printDebugText(String debugText) {
        this.debugText = debugText;
    }

    private void printDebugText(Graphics g) {

        if (debugText == null) {
            return;
        }

        g.setColor(Color.RED);
        g.drawChars(debugText.toCharArray(), 0, debugText.length(), 15, 15);
    }

    private static void printImage(Graphics g, BufferedImage bufferedImage, JRouletteResultPanel panel) {
        g.drawImage(bufferedImage, panel.getWidth() / 2 - bufferedImage.getWidth() / 2, panel.getHeight() / 2 - bufferedImage.getHeight() / 2, panel);
    }

    private static void printHeadline(Graphics g, String text, JRouletteResultPanel panel) {

    }

    private static void printDescription(Graphics g, String text, JRouletteResultPanel panel) {

    }

    public void setRouletteResult(RouletteResult bufferedImage) {

        this.rouletteResult = bufferedImage;
        repaint();
    }
}
