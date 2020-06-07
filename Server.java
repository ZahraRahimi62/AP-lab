package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int count = 0;

        try (ServerSocket welcomingSocket = new ServerSocket(7660)) {

            while (count < 50) {
                System.out.print("Server started.\nWaiting for a client ... ");
                Socket connectionSocket = welcomingSocket.accept();
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(connectionSocket, count));
                count++;
            }

            pool.shutdown();
            System.out.print("done.\nClosing server ... ");

        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }

}

class ClientHandler implements Runnable {

    private Socket connectionSocket;
    private int clientNum;

    public ClientHandler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum = clientNum;
    }

    @Override
    public void run() {
        try {
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];

            int a = 0;
            String resultF = "";
            byte[] result = new byte[2048];

            int available = in.available();

            while (available > 0) {
                int read = in.read(buffer);
                String s = new String(buffer, 0, read);
                System.out.println("RECV from " + clientNum + ": " + s);
                resultF += s + " ";
                result = resultF.getBytes();
                out.write(result);
                System.out.println("SENT to client" + clientNum + ": " + resultF);
            }
            System.out.print("All messages sent.\nClosing client ... ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
