package services;

import models.Message;
import models.User;

import java.util.List;

public interface MessageService {

    public Message sendMessage(User sender, User receiver, String data);
    public List<Message> getUserMessages(User user);

    public List<Message> getMostRecentMessages(User user);


}
