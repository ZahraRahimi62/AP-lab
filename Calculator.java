package com.company;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Calculator implements ActionListener {
    JPanel panel;
    JFrame frame;
    JTextField textField;
    boolean isTheFirst = true;
    JButton plus, sub, multi, div, cls, equalBut;
    private double result, preResult;
    private int c;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        frame.setLayout(null);

        addText();
        addKeys();

        addMenu();

        frame.addKeyListener(new KeyHandler());
        frame.setFocusable(true);

    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu1 = new JMenu("Window");
        menu1.setMnemonic('N');
        menuBar.add(menu1);

        JMenuItem item1 = new JMenuItem("Exit");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        menu1.add(item1);

        JMenuItem item2 = new JMenuItem("CopyText");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringSelection string = new StringSelection(String.valueOf(result));
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(string, null);
                JOptionPane.showMessageDialog(null, "Copied to clipboard");
            }
        });
        menu1.add(item2);
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    }

    public void showCalculator() {
        frame.setVisible(true);
    }

    private void addKeys() {
        panel = new JPanel();
        panel.setSize(200, 300);
        panel.setLocation(250, 70);
        panel.setLayout(new GridLayout(4, 3));

        // '1' to '9' char
        JButton button;
        for (int i = 1; i < 10; i++) {
            button = new JButton("" + i);
            String finalButton = button.getText();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String flg = textField.getText();
                    flg += finalButton;
                    textField.setText(flg);
                }
            });
            button.setToolTipText("Button " + i);
            panel.add(button);
        }

        // '+' char
        plus = new JButton("+");
        plus.addActionListener(this);
        plus.setToolTipText("Plus button ");
        panel.add(plus);

//         '0' char
        button = new JButton("0");
        String finalButton = button.getText();
        button.setToolTipText("Button 0");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flg = textField.getText();
                flg += finalButton;
                textField.setText(flg);
            }
        });
        panel.add(button);

        JPanel panelEx = new JPanel(new GridLayout(4, 3));
        panelEx.setSize(150, 300);
        panelEx.setLocation(100, 70);

        // sin/cos
        JButton csinBtn = new JButton("sin/cos");
        csinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTheFirst) {
                    textField.setText("sin");
                } else {
                    textField.setText("cos");
                }
            }
        });
        csinBtn.setToolTipText("Cos & Sin button");
        panelEx.add(csinBtn);

        // tan/cot
        JButton cotTanBtn = new JButton("tan/cot");
        cotTanBtn.setToolTipText("Tan & Cot button");
        cotTanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTheFirst) {
                    textField.setText("tan");
                } else {
                    textField.setText("cot");
                }
            }
        });
        panelEx.add(cotTanBtn);

        //log/exp
        JButton logExpBtn = new JButton("log/exp");
        logExpBtn.setToolTipText("Log & exp button");
        logExpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTheFirst) {
                    textField.setText("log");
                } else {
                    textField.setText("exp");
                }
            }
        });
        panelEx.add(logExpBtn);

        // '*' char
        multi = new JButton("*");
        multi.setToolTipText("Multiplication button");
        multi.addActionListener(this);
        panelEx.add(multi);

        // '/' char
        div = new JButton("/");
        div.setToolTipText("Division button");
        div.addActionListener(this);
        panelEx.add(div);

        // shift button
        JButton shiftBtn = new JButton("shift");
        shiftBtn.setToolTipText("Shift button");
        shiftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String event = textField.getText();
                if (event.equals("sin"))
                    textField.setText("cos");
                else if (event.equals("cos")) {
                    textField.setText("sin");
                }

                if (event.equals("tan")) {
                    textField.setText("cot");
                } else if (event.equals("cot")) {
                    textField.setText("tan");
                }

                if (event.equals("log")) {
                    textField.setText("exp");
                } else if (event.equals("exp")) {
                    textField.setText("log");
                }
            }
        });
        panelEx.add(shiftBtn);

        // 'cls' char
        cls = new JButton("cls");
        cls.setToolTipText("Clear button");
        cls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("");
                result = 0;
            }
        });
        panelEx.add(cls);

        // '-' char
        sub = new JButton("-");
        sub.setToolTipText("Subtraction button");
        sub.addActionListener(this);
        panelEx.add(sub);


        // '=' char
        equalBut = new JButton("=");
        equalBut.setToolTipText("Equal button");
        equalBut.addActionListener(this);
        panel.add(equalBut);


        frame.add(panelEx);
        frame.add(panel);
}


    private void addText(){
        textField = new JTextField("0");
        textField.setSize(350, 50);
        textField.setLocation(100, 20);
        textField.setEditable(false);

        frame.add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == plus){
            preResult = Double.parseDouble(textField.getText());
            textField.setText("");
            c = 1;

        } else if(e.getSource() == sub){
            preResult = Double.parseDouble(textField.getText());
            textField.setText("");
            c = 2;

        } else if(e.getSource() == multi){
            preResult = Double.parseDouble(textField.getText());
            textField.setText("");
            c = 3;

        } else if(e.getSource() == div){
            preResult = Double.parseDouble(textField.getText());
            textField.setText("");
            c = 4;

        } else if(e.getSource() == equalBut){
            result = Double.parseDouble(textField.getText());
            if(c == 1){
                result = result + preResult;
                textField.setText(String.valueOf(result));

            } else if(c == 2){
                result = preResult - result ;
                textField.setText(String.valueOf(result));

            } else if(c == 3){
                result = result * preResult;
                textField.setText(String.valueOf(result));

            } else if(c == 3){
                if(result != 0) {
                    result = preResult / result ;
                    textField.setText(String.valueOf(result));

                } else {
                    System.out.println("It is not dividable");

                }
            }

        }
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent k) {
            int keyCode = k.getKeyCode();
            for(int i = 1; i < 10; i++){
                if(keyCode == i){
                    int finalI = i;
                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String flg = textField.getText();
                            flg += String.valueOf(finalI);
                            textField.setText(flg);
                        }
                    });
                }
            }

            if(keyCode == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
            if(k.isShiftDown() && keyCode == KeyEvent.VK_ADD ){
                plus.addActionListener((ActionListener)this);

            } else if (k.getKeyCode() == KeyEvent.VK_SUBTRACT){
                sub.addActionListener((ActionListener)this);

            } else if (k.getKeyCode() == KeyEvent.VK_DIVIDE){
                div.addActionListener((ActionListener)this);

            } else if (k.getKeyCode() == KeyEvent.VK_EQUALS){
                equalBut.addActionListener((ActionListener)this);

            }
        }
    }

}
