/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("172.17.0.119", 6666);
            System.out.println("Connected to server " + socket);
            OutputStream out = socket.getOutputStream();
            String message = "Hello there! My name is Abul.\n";
            out.write(message.getBytes());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
