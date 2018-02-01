package org.home.mazi.csroulette.view;

import org.home.mazi.csroulette.model.RouletteResult;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JRouletteResultPanel extends JPanel {

    private RouletteResult rouletteResult;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (rouletteResult == null) {
            return;
        }

        printImage(g, rouletteResult.getImage(), this);
        printHeadline(g, rouletteResult.getName(), this);
        printDescription(g, rouletteResult.getDescription(), this);
    }

    private static void printImage(Graphics g, BufferedImage bufferedImage, JRouletteResultPanel panel) {
        g.drawImage(bufferedImage, panel.getWidth() / 2 - bufferedImage.getWidth() / 2, 0, panel);
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
