package services.implementations;

import models.SocialGraph;
import models.User;
import services.SocialService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SocialServiceImpl implements SocialService {
    HashMap<User, List<User>> userFriends;
    public SocialServiceImpl(){
        userFriends = new HashMap<>();

    }

    public void addFriend(User user1, User user2){
        if(user1==user2){
            return;

        }
        List<User> friends = userFriends.getOrDefault(user1,new ArrayList<>());
        friends.add(user2);
        userFriends.put(user1,friends);
        friends = userFriends.getOrDefault(user2,new ArrayList<>());
        friends.add(user1);
        userFriends.put(user2,friends);




    }
    public void removeFriend(User user1, User user2){
        if(user1==user2){
            return;

        }
        List<User> friends = userFriends.getOrDefault(user1,new ArrayList<>());
        friends.remove(user2);
        userFriends.put(user1,friends);
        friends = userFriends.getOrDefault(user2,new ArrayList<>());
        friends.remove(user1);
        userFriends.put(user2,friends);


    }

    public boolean isFriend(User user1, User user2){
        List<User> friends = userFriends.getOrDefault(user1,new ArrayList<>());
        return user1==user2 ||  friends.contains(user2);

    }

}
