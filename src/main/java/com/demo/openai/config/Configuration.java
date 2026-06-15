package com.demo.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;

/**
 * @author Pramod Rajane
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    ChatClient chatClient(ChatModel chatModel) {
        return ChatClient.create(chatModel);
    }
}
