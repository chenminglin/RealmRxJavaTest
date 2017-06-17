package com.bethena.realmrxjavatest.bean;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;


/**
 *
 */
public class User extends RealmObject{


    @PrimaryKey
    public String userId;

    public String name;

    public int age;

    public int gender;

    public User() {
    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
