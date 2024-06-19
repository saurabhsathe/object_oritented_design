package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostStore {

    HashMap<User, List<Post>> userPosts;
    public PostStore(){
        userPosts  = new HashMap<>();

    }



    public void addPost(User user, Post p){
        List<Post>  posts = userPosts.getOrDefault(user,new ArrayList<>());
        posts.add(p);
        userPosts.put(user,posts);

    }
    public List<Post> getPosts(User user){
        return userPosts.getOrDefault(user,new ArrayList<>());

    }
}
