/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author rei
 */

public class NewJFrame extends JFrame {

    private JButton btnUp = new JButton("Top");
    private JButton btnDown = new JButton("Down");
    private JButton btnLeft = new JButton("Left");
    private JButton btnRight = new JButton("Right");

    private TopPanel topPanel = new TopPanel();

    public NewJFrame() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(btnUp);
        buttonPanel.add(btnDown);
        buttonPanel.add(btnLeft);
        buttonPanel.add(btnRight);

        topPanel.setBackground(Color.YELLOW);
        this.add(topPanel);
        this.add(buttonPanel, BorderLayout.SOUTH);
        btnLeft.addActionListener(new ButtonListener());
        btnRight.addActionListener(new ButtonListener());
        btnUp.addActionListener(new ButtonListener());
        btnDown.addActionListener(new ButtonListener());
    }

    public static void main(String[] args) {

        NewJFrame mainWindow = new NewJFrame();
        mainWindow.setTitle("Ball Control");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent buttonPressed) {
            if (buttonPressed.getSource() == btnLeft) {
                topPanel.left();
            } else if (buttonPressed.getSource() == btnRight) {
                topPanel.right();
            } else if (buttonPressed.getSource() == btnUp) {
                topPanel.up();
            } else if (buttonPressed.getSource() == btnDown) {
                topPanel.down();
            }
        }
    }

    class TopPanel extends JPanel {

        private int xCoord = -1;
        private int yCoord = -1;
        private Dimension winSize = new Dimension(400, 500);

        public void left() {
            xCoord -= 5;
            repaint();
        }

        public void right() {
            xCoord += 5;
            repaint();
        }

        public void up() {
            yCoord -= 5;
            repaint();
        }

        public void down() {
            yCoord += 5;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return winSize;
        }

        protected void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            super.paintComponent(g);
            if (xCoord<0 || yCoord<0) {
                xCoord = getWidth()/2;
                yCoord = getHeight()/2;
            }
            System.out.println("X" + getWidth());
            g.fillOval(xCoord, yCoord, 50, 50);
            
        }

    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

