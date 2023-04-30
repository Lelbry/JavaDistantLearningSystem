package ru.dudkin.vkr;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/HelloTest")
    public String test(){
        return "Hello";
    }
}
