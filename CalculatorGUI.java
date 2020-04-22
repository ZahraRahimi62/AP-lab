package com.company;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    JFrame calcFrame;

    public CalculatorGUI() {
        calcFrame = new JFrame();
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(500, 300);
        calcFrame.setLocation(100, 200);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);
    }

    public void draw(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(205, 150);
        keyboardPanel.setLayout(new GridLayout(4,3));

        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }

        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        keyboardPanel.add(sumBtn);

        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);

        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);

        calcFrame.add(keyboardPanel);


        JPanel keyboardPanel2 = new JPanel();
        keyboardPanel2.setSize(200,200);
        keyboardPanel2.setLocation(5, 150);
        keyboardPanel2.setLayout(new GridLayout(4,1));

        JButton csinBtn = new JButton();
        csinBtn.setText("sin/cos");
        keyboardPanel2.add(csinBtn);

        JButton logExpBtn = new JButton();
        logExpBtn.setText("log/exp");
        keyboardPanel2.add(logExpBtn);


        JButton PIbtn = new JButton();
        PIbtn.setText("PI");
        keyboardPanel2.add(PIbtn);

        JButton eBtn = new JButton();
        eBtn.setText("e");
        keyboardPanel2.add(eBtn);

        JButton emptyBtn = new JButton();
        emptyBtn.setText("");
        keyboardPanel2.add(emptyBtn);


        JButton shiftBtn = new JButton();
        shiftBtn.setText("shift");
        keyboardPanel2.add(shiftBtn);

        calcFrame.add(keyboardPanel2);

        JPanel keyboardPanel3 = new JPanel();
        keyboardPanel3.setSize(80,200);
        keyboardPanel3.setLocation(405, 150);
        keyboardPanel3.setLayout(new GridLayout(4,1));

        JButton subBtn = new JButton();
        subBtn.setText("-");
        keyboardPanel3.add(subBtn);

        JButton miultiBtn = new JButton();
        miultiBtn.setText("*");
        keyboardPanel3.add(miultiBtn);

        JButton divideBtn = new JButton();
        divideBtn.setText("/");
        keyboardPanel3.add(divideBtn);

        JButton modBtn = new JButton();
        modBtn.setText("%");
        keyboardPanel3.add(modBtn);

        calcFrame.add(keyboardPanel3);
        calcFrame.setVisible(true);
    }

    /**
     *
     */
    public void drawScreen(){
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", 14,14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(50,20);
        calcFrame.setVisible(true);
    }
}
