/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resizablecomponentex;

import java.awt.*;
import javax.swing.*;
 
public class MultiPanels {
    private JScrollPane getContent() {
        Dimension d = new Dimension(300,200);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(getPanel(d,  6, Color.red), gbc);
        panel.add(getPanel(d,  4, Color.green.darker()), gbc);
        panel.add(getPanel(d, 12, Color.blue), gbc);
        panel.add(getEmptyPanel(d), gbc);
        return new JScrollPane(panel);
    }
 
    private JScrollPane getPanel(Dimension d, int rows, Color color) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(color);
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.insets = new Insets(10,5,10,5);
        gbc.weightx = 1.0;
        for(int i = 0, j = 1; i < rows; i++) {
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            panel.add(new JButton(String.valueOf(j++)), gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            panel.add(new JButton(String.valueOf(j++)), gbc);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(d);
        return scrollPane;
    }
 
    private JScrollPane getEmptyPanel(Dimension d) {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0,0,Color.red,
                                                     0,h,Color.cyan);
                ((Graphics2D)g).setPaint(gp);
                g.fillRect(0,0,w,h);
            }
        };
        // Default size for a JPanel is (10,10). Its layout
        // manager computes its preferredSize while laying
        // out the child components. If there are no children
        // the panel reports its default size to its parent.
        // Use the [i]setPreferredSize[/i] method to provide
        // a size hint to the parent of this component.
        panel.setPreferredSize(new Dimension(300,400));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(d);
        return scrollPane;
    }
 
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MultiPanels().getContent());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
