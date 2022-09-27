package com.bargans.entities;

import java.util.ArrayList;
import java.util.List;

public class subscription {
    private String user;

    private List<String> subs;

    public subscription(String user, List<String> subs) {
        this.user = user;
        this.subs = subs;
    }
    public subscription(String user){
        this.subs = new ArrayList<String>();

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getSubs() {
        return subs;
    }

    public void setSubs(List<String> subs) {
        this.subs = subs;
    }

    public void addSubscriber(String user){
        this.subs.add(user);
    }

}
