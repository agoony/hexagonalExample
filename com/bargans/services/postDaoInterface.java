package com.bargans.services;

import com.bargans.entities.Post;

import java.util.List;

public interface postDaoInterface {
    // get all post from users
    List<Post> reading(String user);

    void posting(Post myPost);

    List<Post> Wall(String user);

    void Subscribe(String user, String targetuser);


}
