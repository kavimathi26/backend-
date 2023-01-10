package com.example.crud;
import java.util.*;

public class newUser {
    Map<Integer,String> users = new LinkedHashMap<>();
    private int index = 1;
    private String name;
    public void createUser(String user) { //create
        users.put(index++, user);
        System.out.println(users);
    }
    public Map displayUsers() { //get all
        System.out.println(users);
        return users;
    }
    public Object displayOne(Integer id) { //get one
        System.out.println(users.get(id));
        return users.get(id);
    }
    public void deleteUser(Integer id) { //delete
        users.remove(id);
        System.out.println(users);
    }
}
