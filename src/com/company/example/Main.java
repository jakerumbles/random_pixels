package com.company.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static int HEIGHT = 1200;
    public static int WIDTH = 1200;
    public static JFrame frame;
    public static ImageIcon ii;
    public static JLabel label;
    public static int imageCounter = 0;

    public static void main(String[] args) throws IOException{

        //Create frame
        frame = new JFrame("Random Pixels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createRandomImage();

        String workingDir = System.getProperty("user.dir");
        String imagePath = workingDir + "\\images\\random_pixels" + imageCounter + ".png";

        ii = new ImageIcon(imagePath);
        label = new JLabel(ii);
        JButton button = new JButton("Randomize!");


        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        button.addActionListener(new ClickEvent());

        //Size frame
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        //Show frame
        frame.setVisible(true);

    }

    public static class ClickEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            imageCounter++;
            createRandomImage();
            String workingDir = System.getProperty("user.dir");
            String imagePath = workingDir + "\\images\\random_pixels" + imageCounter + ".png";
            label.setIcon(new ImageIcon(imagePath));
            frame.getContentPane().add(label, BorderLayout.CENTER);

            System.out.println("Random clicked");
        }
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
            String workingDir = System.getProperty("user.dir");
            System.out.println(workingDir);
            String imagePath = workingDir + "\\images\\random_pixels" + imageCounter + ".png";
            System.out.println(imagePath);

            f = new File(imagePath);
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
