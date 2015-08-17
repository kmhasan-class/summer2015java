/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Server {
    private int portNumber;
    
    public Server(int portNumber) {
        this.portNumber = portNumber;
        byte buffer[];
        
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                System.out.println("Waiting on clients...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with " + clientSocket);
                
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();
                
                buffer = new byte[1000];
                int errorCode = in.read(buffer);
                String message = new String(buffer);
                System.out.println(message.length() + " " + message);
                message = message.toUpperCase();
                
                out.write(message.getBytes());
                out.flush();
                
                System.out.println("Error code: " + errorCode);
                if (message.startsWith("Bye"))
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
