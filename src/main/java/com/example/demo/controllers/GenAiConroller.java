package com.example.demo.controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenAiConroller {
    private final ChatClient chatClient;

    public GenAiConroller(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }
    @GetMapping
    private String getPromt(@RequestParam String message){

        return chatClient.prompt(message)
                .call()
                .content();
    }
}
