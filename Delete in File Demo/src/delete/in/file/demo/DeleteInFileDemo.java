/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete.in.file.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class DeleteInFileDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("demo.txt", "rw");
            String line;
            String input = "";
            while (true) {
                line = file.readLine();
                if (line == null)
                    break;
                if (!line.equals("Jackfruit"))
                    input = input + line + "\n";
            }
            file.setLength(0);
            file.writeBytes(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeleteInFileDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeleteInFileDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
