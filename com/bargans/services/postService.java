package com.bargans.services;

import com.bargans.entities.Post;

import java.util.List;

public class postService implements postDaoInterface{


    private postDaoInterface dao;

    public postService(postDaoInterface postDao) {
        dao = postDao;
    }

    @Override
    public List<Post> reading(String user) {
        return  dao.reading(user);
    }

    @Override
    public void posting(Post myPost) {
        dao.posting(myPost);
    }

    @Override
    public List<Post> Wall(String user) {
        return dao.Wall(user);
    }

    @Override
    public void Subscribe(String user, String targetUser) {
        dao.Subscribe(user, targetUser);
    }
}
