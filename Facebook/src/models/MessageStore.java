package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageStore {

    HashMap<User, List<Message>> userMessages;
    public MessageStore(){
        userMessages  = new HashMap<>();

    }



    public void addMessage(User user, Message m){
        List<Message>  msgs = userMessages.getOrDefault(user,new ArrayList<>());
        msgs.add(m);
        userMessages.put(user,msgs);

    }
    public List<Message> getMessages(User user){
        return userMessages.getOrDefault(user,new ArrayList<>());

    }
}
