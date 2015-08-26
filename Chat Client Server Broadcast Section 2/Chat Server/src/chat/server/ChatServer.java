/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.IOException;
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
    ArrayList<ThreadedServer> threadedServers;
    
    public ChatServer(int portNumber) {
        this.portNumber = portNumber;
        threadedServers = new ArrayList<>();
        
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                System.out.println("Waiting on clients...");
                Socket clientSocket = serverSocket.accept();
                
                ThreadedServer threadedServer = new ThreadedServer(clientSocket, this);
                threadedServer.start();
                threadedServers.add(threadedServer);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void broadcast(String message) {
        for (ThreadedServer t: threadedServers) {
            try {
                t.getClientSocket().getOutputStream().write(message.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String args[]) {
        new ChatServer(6666);
    }
}
