/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ThreadedServer extends Thread {
    private Socket clientSocket;
    private ChatServer chatServer;
    
    public ThreadedServer(Socket clientSocket, ChatServer chatServer) {
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
    }
    
    @Override
    public void run() {
                InputStream in = null;
        try {
            System.out.println("Connected with " + clientSocket);
            in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            
            while (true) {
                byte buffer[] = new byte[1000];
                in.read(buffer);
                String message = new String(buffer);
                message = message.trim();
                chatServer.broadcast(message);
                if (message.length() == 0 || message.equals("QUIT")) {
                    System.out.println("Done with " + clientSocket);
                    break;
                }
                Date date = new Date();
                System.out.println("[" + date + "] " + clientSocket.getInetAddress() + ": " + message);
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public ChatServer getChatServer() {
        return chatServer;
    }
    
}
