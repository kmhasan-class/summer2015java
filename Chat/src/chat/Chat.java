/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author kmhasan
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int portNumber = 6666;
        Server server = new Server(portNumber);
    }
    
}
