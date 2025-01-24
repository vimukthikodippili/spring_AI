package com.example.demo.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Rest Controller to handle image-related functionalities such as
 * describing an image and generating an image based on a given prompt.
 */
@RestController
@RequestMapping("/api")
public class ImageController {

    // Dependency for interacting with chat-based AI
    private final ChatModel chatModel;

    // Dependency for interacting with image generation AI
    private final ImageModel imageModel;

    public ImageController(ChatModel chatModel, ImageModel imageModel) {
        this.chatModel = chatModel;
        this.imageModel = imageModel;
    }
    /**
     * Endpoint to describe an image by passing it to the ChatClient.
     *
     * @return A textual description of the image provided as input.
     */
    @GetMapping("/image-to-text")
    public String describeImage(){
    String response=   ChatClient.create(chatModel)
               .prompt()
               .user(useSpec ->
                   useSpec.text("explain what do you see in this image")
                           .media(MimeTypeUtils.IMAGE_JPEG,
                                   new ClassPathResource("image/download (1).jpg")))
               .call()
               .content();
return response;
    }
    /**
     * Endpoint to generate an image based on a given prompt.
     *
     * @param prompt The textual description for the image to be generated.
     * @return The URL of the generated image.
     */
    @GetMapping("/get-image/{prompt}")
    public String generateImage(@PathVariable String prompt){
        ImageResponse imageResponse=imageModel.call(
                new ImagePrompt(
                        prompt,
                        OpenAiImageOptions
                                .builder()
                                .withN(1)
                                .withHeight(1024)
                                .withWidth(1024)
                                .withQuality("hd")
                                .build()));
return imageResponse.getResult().getOutput().getUrl();
    }
}
