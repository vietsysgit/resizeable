/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resizablecomponentex;

/**
 *
 * @author Brian Vo
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResizableComponentEx extends JFrame {

    private Resizable res;

    public ResizableComponentEx() {

        initUI();
    }

    private void initUI() {

        JPanel pnl = new JPanel(null);
        add(pnl);

        JPanel area = new JPanel();
        area.setBackground(Color.white);
        res = new Resizable(area);
        res.setBounds(50, 50, 200, 150);
        pnl.add(res);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {

                requestFocus();
                res.repaint();
            }
        });

        setSize(350, 300);
        setTitle("Resizable component");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResizableComponentEx ex = new ResizableComponentEx();
                ex.setVisible(true);
            }
        });
    }
}
