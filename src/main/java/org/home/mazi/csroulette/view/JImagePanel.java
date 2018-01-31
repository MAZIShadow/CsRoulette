package org.home.mazi.csroulette.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JImagePanel extends JPanel {

    private BufferedImage bufferedImage;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bufferedImage == null) {
            return;
        }

        g.drawImage(bufferedImage, 0, 0, this);
    }

    public void setImage(BufferedImage bufferedImage) {

        this.bufferedImage = bufferedImage;
        repaint();
    }

    public void setImage(String path) {

        bufferedImage = null;
        File file = new File(path);

        if (!file.exists()) {
            return;
        }
        try {
            setImage(ImageIO.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
