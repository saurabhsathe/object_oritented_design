package services;

import models.User;

public interface SocialService {

    public void addFriend(User user1, User user2);
    public void removeFriend(User user1, User user2);
    public boolean isFriend(User user1, User user2);

}
