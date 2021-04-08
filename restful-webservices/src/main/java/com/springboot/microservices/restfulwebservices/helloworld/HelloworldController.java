package com.springboot.microservices.restfulwebservices.helloworld;


import com.springboot.microservices.restfulwebservices.helloworld.HelloworldBean;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {



   //@RequestMapping(method=RequestMethod.GET,path = "/hello-world")
   @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "Hello-world";
    }

    @GetMapping(path ="/hello-world-bean")
    public HelloworldBean helloworldBean(){
       return new HelloworldBean("Hello-world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloworldBean helloworldpathVariable(@PathVariable String name){
       return new HelloworldBean(String.format("hello world, %s",name));
    }

}
