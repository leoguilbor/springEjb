package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import simpleEjb.HelloStatelessWorld;



@RestController
public class EjbController {

	@Autowired
	private HelloStatelessWorld helloStatelessWorld;
	
    @GetMapping("/stateless")
    public String getStateless() {
        return helloStatelessWorld.getHelloWorld();
    }
     
	
}
