package services;

import models.Post;
import models.User;

import java.util.List;

public interface PostService {


    public Post createPost(User sender, String data);
    public List<Post> getUserPosts(User user);

    public List<Post> getMostRecentUserPosts(User user);


}
