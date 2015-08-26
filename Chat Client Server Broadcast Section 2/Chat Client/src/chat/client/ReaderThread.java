/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ReaderThread implements Runnable {
    Socket serverSocket;
    InputStream in;
    FXMLDocumentController parentClient;
    
    ReaderThread(Socket serverSocket, FXMLDocumentController parentClient) {
        this.serverSocket = serverSocket;
        this.parentClient = parentClient;
        
        try {
            in = serverSocket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(ReaderThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                byte[] buffer = new byte[1000];
                in.read(buffer);
                String inputMessage = new String(buffer).trim();
                parentClient.display(inputMessage);
                //messageArea.appendText(message + "\n");
            } catch (IOException ex) {
                Logger.getLogger(ReaderThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
