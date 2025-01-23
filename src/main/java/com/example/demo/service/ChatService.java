//package com.example.demo.service;
//
//import com.theokanning.openai.completion.chat.ChatCompletionChoice;
//import com.theokanning.openai.completion.chat.ChatCompletionRequest;
//import com.theokanning.openai.completion.chat.ChatMessage;
//import com.theokanning.openai.service.OpenAiService;
//import org.springframework.stereotype.Service;
//
//
//import java.util.Collections;
//
//@Service
//public class ChatService {
//    private final OpenAiService openAiService;
//
//    public ChatService(OpenAiService openAiService) {
//        this.openAiService = openAiService;
//    }
//    public String getChatResponse(String userMessage) {
//        try {
//            // Create a ChatMessage object for the user input
//            ChatMessage userInput = new ChatMessage("user", userMessage);
//
//            // Build the ChatCompletionRequest
//            ChatCompletionRequest chatRequest = ChatCompletionRequest.builder()
//                    .model("gpt-3.5-turbo") // Ensure the model is correct
//                    .messages(Collections.singletonList(userInput))
//                    .maxTokens(100) // Limit the response length
//                    .temperature(0.7) // Adjust creativity
//                    .build();
//
//            // Call the OpenAiService and get the response
//            var chatResponse = this.openAiService.createChatCompletion(chatRequest);
//
//            // Check for successful response and return the content
//            if (chatResponse != null && chatResponse.getChoices() != null && !chatResponse.getChoices().isEmpty()) {
//                ChatCompletionChoice choice = chatResponse.getChoices().get(0); // Get the first choice
//                return choice.getMessage().getContent();
//            } else {
//                return "No response from the model.";
//            }
//        } catch (Exception e) {
//            // Log and return an error message in case of failure
//            e.printStackTrace();
//            return "Error while processing the request.";
//        }
//    }
//}
