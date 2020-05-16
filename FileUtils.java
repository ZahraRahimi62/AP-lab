package com.company;

import javax.swing.*;
import javax.tools.StandardJavaFileManager;
import java.awt.event.*;
import java.io.*;
import java.net.FileNameMap;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
//        File f = new File("D:\\fileGui.txt");
        FileReader fileReader;
        String read = "";
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                read += bufferedReader.readLine() + "\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException notFile){
                Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        return read;
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        final String[] toWrite = {content};

        toWrite[0] = toWrite[0] + "\n\n" + "Title: " + getProperFileName(content) + "  ,Date: " + new Date().toString();
        String fileName = getProperFileName(content);
        FileWriter file;
        try{
            file = new FileWriter(NOTES_PATH + fileName + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.write(toWrite[0]);
            bufferedWriter.close();
            file.close();


        } catch (FileNotFoundException notFile){
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    //TODO: Phase1: define method here for reading file with InputStream

    public static String readOutputStream(File file) {
        //TODO: Phase1: read content from file
//        File f = new File("D:\\fileGui.txt");
        String read = "";
        try {
            FileInputStream inputStream = new FileInputStream(file);
            while (inputStream.available() > 0){
                read += (char) inputStream.read();
            }
            inputStream.close();

        } catch (FileNotFoundException notFile){
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        return read;
    }

    //TODO: Phase1: define method here for writing file with OutputStream

    public static void writeOutputStream(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);
        File f = new File("D:\\fileGui.txt");
        try{
            FileOutputStream outputStream = new FileOutputStream(f);
            char [] chars = content.toCharArray();
            byte [] bytes = new byte[chars.length];
            for(int i = 0; i < bytes.length; i++){
                bytes[i] = (byte) chars[i];
            }
            outputStream.write(bytes);
            outputStream.close();
        } catch (FileNotFoundException notFile){
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }


    //TODO: Phase2: proper methods for handling serialization
    public Note readObject(File file){
        Note note = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(inputStream);
            ObjectInputStream objectInput = new ObjectInputStream(bufferedInput);
            note = (Note) objectInput.readObject();
            objectInput.close();
            bufferedInput.close();
        } catch (FileNotFoundException notFile){
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return note;
    }

    public void writeObject(Note note){
        try {
            FileOutputStream outputStream = new FileOutputStream(NOTES_PATH + note.getTitle() + ".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(note);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException notFile){
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, notFile);
        } catch (IOException e) {
            Logger.getLogger(StandardJavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }


    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt" ;
    }
}
