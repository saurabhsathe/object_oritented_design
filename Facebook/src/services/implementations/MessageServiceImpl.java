package services.implementations;

import models.Message;
import models.MessageStore;
import models.User;
import services.MessageService;
import services.SocialService;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MessageServiceImpl implements MessageService {

    MessageStore msgStore ;
    SocialService socialService;
    public MessageServiceImpl(MessageStore messageStore, SocialService service){
        this.msgStore = messageStore;
        socialService=service;

    }

    public Message sendMessage(User sender, User receiver, String data){
        Message msg = new Message(sender,receiver,data);
        msgStore.addMessage(sender,msg);
        msgStore.addMessage(receiver,msg);
        return msg;
    }
    public List<Message> getUserMessages(User user){
        List<Message> response = new ArrayList<>();

        for(Message msg:msgStore.getMessages(user)){
            if(((msg.getSender()==user || msg.getReceiver()==user ) && socialService.isFriend(msg.getSender(),msg.getReceiver()))){
                response.add(msg);
            }

        }
        return response;



    }

    public List<Message> getMostRecentMessages(User user){
        Queue<Message> heap = new PriorityQueue<Message>(5,(a,b)->a.getCreationTime().compareTo(b.getCreationTime()));
        List<Message> response = new ArrayList<>();

        for(Message msg:msgStore.getMessages(user)){
            if((msg.getSender().equals(user)  || msg.getReceiver().equals(user)) && socialService.isFriend(msg.getSender(),msg.getReceiver()))
                heap.add(msg);

        }
        while(heap.size()>0 && response.size()<5){
            response.add(heap.poll());
        }
        return response;




    }
}
