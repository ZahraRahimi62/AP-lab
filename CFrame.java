package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CFrame extends JFrame implements ActionListener {

    private CMainPanel mainPanel;

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;


    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    private void initMainPanel() {
        mainPanel = new CMainPanel();
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            mainPanel.addNewTab();
        } else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        } else if (e.getSource() == exitItem) {
            //TODO: Phase1: check all tabs saved ...
            mainPanel.checkTabSaved();
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }

    public void readAndWriteObject(){
        Note note1 = new Note("Test1", "This is tmp", "1398/03/12");
        Note note2 = new Note("Test2", "This is tmp2", "1397/04/17");

        try(FileOutputStream fs = new FileOutputStream("note.bin")){
            ObjectOutputStream oos = new ObjectOutputStream(fs);

            oos.writeObject(note1);
            oos.writeObject(note2);
        } catch (FileNotFoundException fn){
            fn.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fi = new FileInputStream("note.bin")){
            ObjectInputStream oos = new ObjectInputStream(fi);

            Note note11 = (Note) oos.readObject();
            Note note22 = (Note) oos.readObject();

            System.out.println(note11 );
            System.out.println(note22);
        } catch (FileNotFoundException fn){
            fn.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException cf){
            cf.printStackTrace();
        }
    }

}

