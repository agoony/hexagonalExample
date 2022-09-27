package com.bargans.dao;

import com.bargans.entities.Post;
import com.bargans.entities.subscription;
import com.bargans.services.postDaoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostDaoMock implements postDaoInterface {

    //user + Post
    private ArrayList<Post> posts = new ArrayList<Post>();

    private ArrayList<subscription> subs = new ArrayList<subscription>();

    public PostDaoMock() {
        //add some posts
        posts.add(new Post("I love the weather today", "Alice"));
    }

    @Override
    public ArrayList<Post> reading(String user) {
        ArrayList<Post> results = new ArrayList<Post>();
        for (Post i : posts) {
            if(i.getAuthor().equals(user))
                results.add(i);
        }
        Collections.sort(results);
        return results;
    }

    @Override
    public void posting(Post myPost) {
        posts.add(myPost);
    }

    @Override
    public List<Post> Wall(String user) {
        List<Post> wallPosts = new ArrayList<Post>();
        subscription userSubs = loadSubs(user);
        for(String userFollowed: userSubs.getSubs())
        {
            for(Post rPost: this.posts)
            {
                if(rPost.getAuthor().equals(userFollowed))
                    wallPosts.add(rPost);
            }
        }

        return wallPosts;
    }

    @Override
    public void Subscribe(String user, String targetUser) {

        subscription userSubs = loadSubs(user);
        userSubs.addSubscriber(targetUser);
    }

    private subscription loadSubs(String user){
        subscription userSubs = null;
        for (subscription s :subs)
        {
            if (s.getUser().equals(user)) {
                userSubs = s;
                break;
            }
        }
        if(userSubs==null)
            userSubs = new subscription(user);
        return  userSubs;
    }

}
