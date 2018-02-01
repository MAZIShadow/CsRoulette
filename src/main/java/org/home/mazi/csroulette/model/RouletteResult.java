package org.home.mazi.csroulette.model;

import com.google.gson.annotations.Expose;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class RouletteResult implements Serializable {
    private String name;
    private String description;
    private String imagePath;
    @Expose
    private BufferedImage image;

    public RouletteResult() {

    }

    public RouletteResult(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public BufferedImage getImage() {

        if (image == null) {

            File imageFile = new File(imagePath);

            if (!imageFile.exists()) {
                imageFile = new File(ClassLoader.getSystemClassLoader().getResource("NoResult.png").getFile());
            }

            image = loadImageFromFile(imageFile);
        }


        return image;
    }

    private static BufferedImage loadImageFromFile(File imageFile) {
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void loadImage(File f) {

        String imagePath = f.getAbsolutePath().replaceAll("\\.json$", "\\.png");

        File imageFile = new File(imagePath);

        if (!imageFile.exists()) {
            return;
        }

        image = loadImageFromFile(imageFile);
    }
}
