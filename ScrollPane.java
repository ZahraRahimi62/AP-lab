package com.company;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JFrame{
    JTextArea textArea ;
    JScrollPane scrollPane = new JScrollPane();

    public ScrollPane(JFrame cal){
        textArea = new JTextArea(10, 20);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(cal.EXIT_ON_CLOSE);
        add(scrollPane);
        setSize(400, 400);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}
