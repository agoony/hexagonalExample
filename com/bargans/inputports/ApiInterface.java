package com.bargans.inputports;

public interface ApiInterface {

    String posting(String user, String post);

     void reading(String user);

    void following(String user, String targetUser);

    void wall(String user);
}
