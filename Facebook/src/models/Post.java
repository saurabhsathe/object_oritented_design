package models;

import java.util.Date;

public class Post {

    User creator;
    String content;
    Date messageCreation;


    public Post(User creator,String data){
        this.creator=creator;
        this.content = data;
        messageCreation = new Date();

    }


}
