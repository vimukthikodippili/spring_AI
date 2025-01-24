package com.example.demo.controllers;


import com.example.demo.model.Achievements;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * REST controller for handling AI-based prompt generation and response.
 */
@RestController
@RequestMapping("/api")
public class GenAiConroller {
    // ChatClient instance to handle communication with the AI chat service.
    private final ChatClient chatClient;

    /**
     * Constructor for initializing the ChatClient instance.
     *
     * @param chatClient ChatClient.Builder instance for building the ChatClient.
     */
    public GenAiConroller(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }
    /**
     * Endpoint to send a message to the AI service and get a response.
     *
     * @param message The user-provided message to send to the AI service.
     * @return The AI's response as a String.
     */
    @GetMapping
    private String getPromt(@RequestParam String message){

        return chatClient.prompt(message)
                .call()
                .content();
    }
    /**
     * Endpoint to get details about a celebrity.
     *
     * @param name The name of the celebrity.
     * @return A formatted string containing details about the celebrity's career and achievements.
     */
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
    /**
     * Endpoint to get details about a sport, including its rules and regulations.
     *
     * @param name The name of the sport.
     * @return A formatted string containing details about the sport, including its rules.
     */
    @GetMapping("/sports")
    public String getSports(@RequestParam String name) {
        String userMessage = String.format("""
            list the details of the sports %s
            along with their rules and regulations show the details in the readable format
            """, name);
        // System message to guide the AI's behavior and restrict its responses.
        String systemMessage = """
            You are a smart virtual assistant. Your task is to give the details about sports. If someone asks about something else you don't know, just 
            answer 'I don't know.'
            """;

        PromptTemplate template = new PromptTemplate(userMessage);
        Prompt prompt = template.create(
                Map.of("systemMessage", systemMessage)
        );
        // Sends the prompt to the AI service and extracts the response content.

        return chatClient.prompt(prompt)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getContent();
    }
   @GetMapping("/achievements")
    public Achievements getAchievements(@RequestParam String name){
        String message= """
                provide a list of achievements for {player}
                """;
PromptTemplate template =new PromptTemplate(message);
Prompt prompt =template.create(Map.of("player",name));
 return chatClient .prompt(prompt)
         .call()
         .entity(new ParameterizedTypeReference<Achievements>() {
         });

   }
}
