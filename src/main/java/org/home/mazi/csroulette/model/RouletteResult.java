package org.home.mazi.csroulette.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class RouletteResult implements Serializable {
    private String name;
    private String description;
    private String imagePath;
    private transient BufferedImage image;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RouletteResult that = (RouletteResult) o;

        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }

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

        String tmpImagePath = f.getAbsolutePath().replaceAll("\\.json$", "\\.png");

        File imageFile = new File(tmpImagePath);

        if (!imageFile.exists()) {
            return;
        }

        image = loadImageFromFile(imageFile);
    }
}
