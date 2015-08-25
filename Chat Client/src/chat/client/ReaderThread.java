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
public class ReaderThread extends Thread {

    Socket serverSocket;
    FXMLDocumentController fxmlDocumentController;
    
    public ReaderThread(Socket serverSocket, FXMLDocumentController fxmlDocumentController) {
        this.serverSocket = serverSocket;
        this.fxmlDocumentController = fxmlDocumentController;
    }

    @Override
    public void run() {
        try {
            while (true) {
                InputStream in = serverSocket.getInputStream();
                byte[] buffer = new byte[1000];
                in.read(buffer);
                String inputMessage = new String(buffer);
                inputMessage = serverSocket.getInetAddress() + ": " +  inputMessage;
                fxmlDocumentController.displayInMessageArea(inputMessage.trim() + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReaderThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
