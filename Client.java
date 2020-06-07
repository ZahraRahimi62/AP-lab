package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private static InputStream in;
    private static OutputStream out;
//    InputStream in;
    public static void main(String[] args) {
        ArrayList<String> messages = new ArrayList<String>();
        messages.add(" ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Print your strings:");
        String string = scanner.next();

        int a = 0;
        while (!string.equals("over")){
            messages.add(string);
            string = scanner.next();
            a++;
        }
        if(a==0){
            return;
        }

        try{
            Socket client = new Socket("192.168.1.5", 7660);
            System.out.println("Connected to server.");

            in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());

            byte[] buffer = new byte[2048];
            for (String s : messages) {
                if(!s.equals(" ")) {
                    out.write(s.getBytes());
                    System.out.println("SENT: " + s);

                    int read = in.read(buffer);
                    System.out.println("RECV: " + new String(buffer, 0, read));
                }

            }
            System.out.print("All messages sent.\nClosing ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
