package com.bargans.inputports;

import com.bargans.entities.Post;
import com.bargans.services.postService;

import java.util.List;

public class cliPort implements ApiInterface{


    private postService service;

    public cliPort(postService service) {
        this.service = service;
    }


    @Override
    public String posting(String user, String post) {
        Post myPost = new Post(post,user);
        service.posting(myPost);
        return null;
    }

    @Override
    public void reading(String user) {
        List<Post> res =service.reading(user);
        for(Post i : res){
            System.out.println(i.getPost()+" ( 1 minutes ago )");
        };
    }
/*
    private int minutesAgo(LocalDateTime dateTime){
       // return LocalDateTime.now().
    }
*/
    @Override
    public void following(String user, String targetUser) {
        service.Subscribe(user,targetUser);
    }

    @Override
    public void wall(String user) {
        List<Post> res =service.Wall(user);
        for(Post i : res){
            System.out.println(i.getAuthor()+"-"+i.getPost()+" ( 1 minutes ago )");
        };
    }
}
