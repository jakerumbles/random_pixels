package com.company.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static int HEIGHT = 1200;
    public static int WIDTH = 1200;

    public static void main(String[] args) throws IOException{

        //Create frame
        JFrame frame = new JFrame("Random Pixels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        createRandomImage();

        ImageIcon ii = new ImageIcon("C:\\Users\\edwar\\Documents\\Software_Engineering\\random_pixels\\src\\com\\company\\example\\random_pixels.png");
        JLabel label = new JLabel(ii);
        JButton button = new JButton("Randomize!");
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        //Size frame
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        //Show frame
        frame.setVisible(true);

    }

    public static void createRandomImage() {
        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        File f = null;

        for(int x = 0; x < (int)(WIDTH); x++) {
            for(int y = 0; y < (int)(HEIGHT); y++) {
                int a = (int)(Math.random() * 256);
                int r = (int)(Math.random() * 256);
                int g = (int)(Math.random() * 256);
                int b = (int)(Math.random() * 256);
                int pixel = (a<<24) | (r<<16) | (g<<8) | b;

                img.setRGB(x, y, pixel);
            }
        }

        try {
            f = new File("C:\\Users\\edwar\\Documents\\Software_Engineering\\random_pixels\\src\\com\\company\\example\\random_pixels.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
