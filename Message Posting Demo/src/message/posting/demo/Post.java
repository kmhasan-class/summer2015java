/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.posting.demo;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class Post {
    private String message;
    private ArrayList<String> friends;

    public Post(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }
    
    public void addTag(String friend) {
        friends.add(friend);
    }
}
