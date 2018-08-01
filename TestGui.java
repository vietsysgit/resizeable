/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resizablecomponentex;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGui extends JFrame {
    //**************************************************************************************
    //************************************** Variables *************************************
    //**************************************************************************************
    private String[] showHideComboBoxValue = {"Show hiddenLabel", "Hide hiddenLabel"};
    private JComboBox showHideComboBox = createShowHideComboBox(showHideComboBoxValue);
    private JLabel labelHiddenOrShown = createDefaultLabel("This label is hidden or shown depending on the status of the combo box", 14);
    private JPanel topFrame = createTopFrame();
    private JScrollPane topFrameScroll = createTopScrollPane();
    private JScrollPane centerFrameScroll = createCenterScrollPane();

    //**************************************************************************************
    //************************************* Constructor ************************************
    //**************************************************************************************
    private TestGui() {
        add(topFrameScroll, BorderLayout.NORTH);
        add(centerFrameScroll, BorderLayout.CENTER);

        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //**************************************************************************************
    //*********************************** Support Method ***********************************
    //**************************************************************************************
    private static GridBagConstraints setGbc(int gridx, int gridy, int gridWidth, int gridHeight, int ipadx, int ipady, String anchorLocation, double weightx, double weighty, Insets insets, boolean fillCell){
        GridBagConstraints gbc = new GridBagConstraints();

        if (anchorLocation.toUpperCase().equals("NORTHWEST")){
            gbc.anchor = GridBagConstraints.NORTHWEST;
        } else if (anchorLocation.toUpperCase().equals("NORTH")){
            gbc.anchor = GridBagConstraints.NORTH;
        } else if (anchorLocation.toUpperCase().equals("NORTHEAST")){
            gbc.anchor = GridBagConstraints.NORTHEAST;
        } else if (anchorLocation.toUpperCase().equals("WEST")){
            gbc.anchor = GridBagConstraints.WEST;
        } else if (anchorLocation.toUpperCase().equals("EAST")){
            gbc.anchor = GridBagConstraints.EAST;
        } else if (anchorLocation.toUpperCase().equals("SOUTHWEST")){
            gbc.anchor = GridBagConstraints.SOUTHWEST;
        } else if (anchorLocation.toUpperCase().equals("SOUTH")){
            gbc.anchor = GridBagConstraints.SOUTH;
        } else if (anchorLocation.toUpperCase().equals("SOUTHEAST")){
            gbc.anchor = GridBagConstraints.SOUTHEAST;
        } else {
            gbc.anchor = GridBagConstraints.CENTER;
        }

        gbc.gridx = gridx; // column
        gbc.gridy = gridy; // row
        gbc.gridwidth = gridWidth; // number of columns
        gbc.gridheight = gridHeight; // number of rows
        gbc.ipadx = ipadx; // width of object
        gbc.ipady = ipady; // height of object
        gbc.weightx = weightx; // shifts columns to side of set anchor
        gbc.weighty = weighty; // shifts rows to side of set anchor
        gbc.insets = insets; // placement inside cell
        if (fillCell){
            gbc.fill = GridBagConstraints.BOTH;
        }

        return gbc;
    }

    //**************************************************************************************
    //*********************************** Object Methods ***********************************
    //**************************************************************************************
    private JComboBox createShowHideComboBox(String[] comboValues){
        JComboBox comboBox = new JComboBox(comboValues);
        comboBox.setPrototypeDisplayValue("X" + comboValues[0] + "X");

        return comboBox;
    }

    private void createShowHideComboBoxAction(){
        showHideComboBox.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selection = ((JComboBox) (e.getSource())).getSelectedItem().toString();
                        if (selection.equals(showHideComboBoxValue[1])){
                            labelHiddenOrShown.setVisible(false);
                        } else {
                            labelHiddenOrShown.setVisible(true);
                        }
                    }
                }
        );
    }

    private JLabel createDefaultLabel(String text, int textSize){
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font(text, Font.BOLD, textSize));
        return lbl;
    }

    //**************************************************************************************
    //************************************ Panel Methods ***********************************
    //**************************************************************************************
    private JPanel createTopFrame() {
        JPanel pnl = new JPanel();

        Border lineSplitterBoarder = BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLUE);
        JLabel lineSplitterOne = new JLabel();
        lineSplitterOne.setBorder(lineSplitterBoarder);
        JLabel lineSplitterTwo = new JLabel();
        lineSplitterTwo.setBorder(lineSplitterBoarder);

        pnl.setLayout(new GridBagLayout());
        createShowHideComboBoxAction();
        pnl.add(showHideComboBox,setGbc(0,1, 1,1, 0,0,"CENTER", 0, 0, new Insets(10, 10, 10, 0), false));
        pnl.add(createDefaultLabel("Label",14), setGbc(1,0,1,1,0,0,"CENTER",0,0,new Insets(10,10,0,10),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(1,1,1,1,0,0,"CENTER",0,0,new Insets(0,10,0,10),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(1,2,1,1,0,0,"CENTER",0,0,new Insets(0,10,0,10),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(1,3,1,1,0,0,"CENTER",0,0,new Insets(0,10,10,10),false));
        pnl.add(lineSplitterOne, setGbc(2,0,1,4,0,0,"CENTER",0,0,new Insets(0,0,0,0),true));
        pnl.add(createDefaultLabel("Hidden Label Below", 14), setGbc(3,0,8,1,9,9,"CENTER",0,0,new Insets(10,10,0,10),false));
        JPanel labelHiddenOrShownPanel = new JPanel();
        labelHiddenOrShownPanel.setLayout(new GridLayout(1,1));
        labelHiddenOrShownPanel.add(labelHiddenOrShown);
        pnl.add(labelHiddenOrShownPanel, setGbc(3,1,1,1,0,0,"WEST",0,0,new Insets(0,5,0,0),false));
        pnl.add(lineSplitterTwo, setGbc(11,0,1,4,0,0,"CENTER",0,0,new Insets(0,5,0,0),true));
        pnl.add(createDefaultLabel("Label",14), setGbc(12,0,1,1,0,0,"CENTER",0,0,new Insets(10,10,0,0),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(12,1,1,1,0,0,"CENTER",0,0,new Insets(0,10,0,0),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(12,2,1,1,0,0,"CENTER",0,0,new Insets(0,10,0,0),false));
        pnl.add(createDefaultLabel("Label",14), setGbc(12,3,1,1,0,0,"CENTER",0,0,new Insets(0,10,10,0),false));

        return pnl;
    }

    private JScrollPane createTopScrollPane(){
        JScrollPane scrollPane = new JScrollPane();
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border lineBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(224,224,224));
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compoundSetup = BorderFactory.createCompoundBorder(raisedBevel, lineBorder);
        Border compoundFinal = BorderFactory.createCompoundBorder(compoundSetup, loweredBevel);

        //scrollPane.setPreferredSize(new Dimension(0, 160));
        scrollPane.setBorder(compoundFinal);
        scrollPane.getViewport().setView(topFrame);
        return scrollPane;
    }

    private JScrollPane createCenterScrollPane(){
        JScrollPane scrollPane = new JScrollPane();
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border lineBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(224,224,224));
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compoundSetup = BorderFactory.createCompoundBorder(raisedBevel, lineBorder);
        Border compoundFinal = BorderFactory.createCompoundBorder(compoundSetup, loweredBevel);

        scrollPane.setBorder(compoundFinal);
        return scrollPane;
    }

    //**************************************************************************************
    //************************************ Start Program ***********************************
    //**************************************************************************************
    public static void main(String[] args) {
        new TestGui();
    }
}
