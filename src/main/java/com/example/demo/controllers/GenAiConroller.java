package com.example.demo.controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    @GetMapping("/celeb")
    public String getCelebDetails(@RequestParam String name){
        String message = """
                list the details of the famus personility {name}
                along with their carrier achievements and show the details in readable format
                """;
        PromptTemplate template  = new PromptTemplate(message);
        Prompt prompt =template.create(
                Map.of("name",name)

        );
return chatClient.prompt(prompt)
        .call()
        .chatResponse()
        .getResult()
        .getOutput()
        .getContent();
    }
}
