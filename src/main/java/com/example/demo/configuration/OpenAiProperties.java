//package com.example.demo.configuration;
//
//import com.theokanning.openai.service.OpenAiService;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties(prefix = "ai.openai")
//public class OpenAiProperties {
//
//    private String model;
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//    @Bean
//    public OpenAiService openAiService() {
//        // Initialize OpenAiService with your API key
//        return new OpenAiService("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");  // Replace with your actual API key
//    }
//}
