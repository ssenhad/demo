package org.demo;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

        public String
        greet(String name) {
            return "Hello " + name+"!";
        }
    }


