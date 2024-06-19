package models;

import java.util.Date;

public class Message {

    User sender;
    User receiver;
    String content;
    Date messageCreation;


    public Message(User sender,User receiver,String data){
        this.sender=sender;
        this.receiver = receiver;
        this.content = data;
        this.messageCreation = new Date();
    }

    public Date getCreationTime(){

        return messageCreation;
    }
    public User getSender(){

        return sender;
    }

    public User getReceiver(){

        return receiver;
    }


    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
