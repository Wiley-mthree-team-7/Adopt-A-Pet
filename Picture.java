/**
 * Author: therealpj
 * Compliation: javac Picture.java
 * Execution: java Picture
 * Date: 9 May, 2021
 **/

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Picture {
    int width, height;
    private BufferedImage image;
    private JFrame frame;
    private String name;
    
    // Takes in a file name, and keeps track of attributes
    public Picture(String name) {
        if (name == null) throw new IllegalArgumentException("Constructor argument is null");
        if (name.length() == 0) throw new IllegalArgumentException("Constructor argument is empty");

        this.name = name;
        try {
            File file = new File(name);
            this.image = ImageIO.read(file);
            if (image == null) throw new IllegalArgumentException("Could not read image " + name);
            this.width = image.getWidth(null);
            this.height = image.getHeight(null);            
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not open image: " + name);
        }
    }

    public JLabel getJLabel() {
        if (image == null) return null;         // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }
    @SuppressWarnings("deprecation") 
    public void show() {
        // create the GUI for viewing the image if needed
        if (frame == null) {
            frame = new JFrame();
            frame.setContentPane(getJLabel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(this.name);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }

        // draw
        frame.repaint();
    }
}
