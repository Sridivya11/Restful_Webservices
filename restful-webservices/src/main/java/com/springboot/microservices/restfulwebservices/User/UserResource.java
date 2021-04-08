package com.springboot.microservices.restfulwebservices.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    //Retrive all users
    @Autowired
    private UserDAOService userDAOService;

    @GetMapping(path = ("/users"))
    public List<User> retriveAllUsers(){

        return userDAOService.findAll();

    }

    @GetMapping(path = ("/users/{id}"))
    public User retriveOneUsers(@PathVariable int id){
        User Oneuser =userDAOService.findOne( id);

        if(Oneuser == null){
            throw new UserNotFoundException("id :"+id);
        }

        return Oneuser;

    }

    @DeleteMapping(path = ("/users/{id}"))
    public void deleteOneUsers(@PathVariable int id){
        User Oneuser =userDAOService.deleteById( id);

        if(Oneuser == null){
            throw new UserNotFoundException("id :"+id);
        }



    }


    @GetMapping(path = "/users/user/{name}")
    public User  retriveUserwithName(@PathVariable String name){
        return  userDAOService.findwithName(name);

    }


    @PostMapping(path = ("/users"))
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        User savedUsers =userDAOService.Save(user);
        // /users/{id}
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUsers.getId()).toUri();

        return ResponseEntity.created(location).build(); //status code of created

    }




}
