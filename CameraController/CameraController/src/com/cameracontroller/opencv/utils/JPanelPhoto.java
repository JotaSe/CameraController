package com.cameracontroller.opencv.utils;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelPhoto extends JPanel {

    private Image image;

    public JPanelPhoto() {
    }

    public JPanelPhoto(String imageName) {
        if (imageName != null) {
            image = new ImageIcon(getClass().getResource(imageName)).getImage();
        }
    }

    public JPanelPhoto(Image initialImage) {
        if (initialImage != null) {
            image = initialImage;
        }
    }

    public void setImagen(String imageName) {
        if (imageName != null) {
            image = new ImageIcon(getClass().getResource(imageName)).getImage();
        } else {
            image = null;
        }

        repaint();
    }

    public void setImagen(Image newImage) {
        image = newImage;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }
}
