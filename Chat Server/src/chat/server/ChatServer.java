/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ChatServer {
    private int portNumber;
    private ArrayList<Socket> sockets;
    
    public ChatServer(int portNumber) {
        this.portNumber = portNumber;
        sockets = new ArrayList<>();
        
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                System.out.println("Waiting on clients...");
                Socket clientSocket = serverSocket.accept();
                sockets.add(clientSocket);
                
                ThreadedServer threadedServer = new ThreadedServer(clientSocket, this);
                threadedServer.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void broadcast(String message) {
        for (Socket s: sockets) {
            OutputStream out = null;
            try {
                out = s.getOutputStream();
                String sender = s.toString();
                String outputMessage = message;
                out.write(outputMessage.getBytes());
                out.flush();
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String args[]) {
        new ChatServer(6666);
    }
}
