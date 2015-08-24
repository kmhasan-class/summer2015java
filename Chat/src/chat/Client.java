/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            String message = "";
            
            //RandomAccessFile input = new RandomAccessFile("filename", "r");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while ((message = input.readLine()) != null) {
                out.write(message.getBytes());
                out.flush();
                if (message.length() == 0 || message.equals("QUIT"))
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
