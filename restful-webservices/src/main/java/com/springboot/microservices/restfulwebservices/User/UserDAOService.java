package com.springboot.microservices.restfulwebservices.User;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> user = new ArrayList<>();

    private static int count = 3;


    static {
        user.add(new User(1,"Adam",new Date()));
        user.add(new User(2,"Eve",new Date()));
        user.add(new User(3,"will",new Date()));
    }

    //public List<User> Find all

    public List<User> findAll(){

        return user;

    }

    public User Save(User users){

        if(users.getId()==null){
            users.setId(++count);
        }
        user.add(users);
        return users;
    }

    public User findOne(int id){

        for(User users :user){
            if(users.getId()==id){
                return users;
            }
        }
        return null;
    }

    public User findwithName(String name){
        for(User users :user){
            if(users.getName().equals(name)){
                return users;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> itreator = user.iterator();
        while(itreator.hasNext()){
            User users = itreator.next();
            if(users.getId()==id){
                itreator.remove();
                return users;
            }
        }
        return null;
    }

}
