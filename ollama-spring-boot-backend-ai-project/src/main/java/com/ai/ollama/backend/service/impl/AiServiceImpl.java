package com.ai.ollama.backend.service.impl;

import com.ai.ollama.backend.service.AiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Service implementation for AI-based interactions using ChatClient.
 * This service allows sending prompts to an AI model and retrieving responses
 * either as a single synchronous response or as a reactive stream of responses.
 */
@Service
public class AiServiceImpl implements AiService {

    /**
     * ChatClient is responsible for interacting with an AI model by sending prompts
     * and receiving responses. It abstracts the complexity of API calls to an external AI service.
     */
    private final ChatClient chatClient;

    /**
     * Constructs an AiServiceImpl instance using a ChatClient.Builder.
     *
     * @param chatClientBuilder The builder used to create a ChatClient instance.
     *                          The builder allows customization of the chat client before initialization.
     */
    public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Sends a prompt to the AI and retrieves a single response synchronously.
     *
     * @param prompt The input query for the AI model.
     * @return The AI-generated response as a single String.
     */
    @Override
    public String askAi(String prompt) {
        return chatClient.prompt(prompt).call().content();
    }

    /**
     * Sends a prompt to the AI and retrieves a stream of responses asynchronously.
     * Flux<T> is a reactive stream that can emit multiple values asynchronously.
     * It is useful for handling real-time data and non-blocking applications.
     * It is widely used in Spring WebFlux to handle asynchronous HTTP requests.
     *
     * @param prompt The input query for the AI model.
     * @return A Flux of Strings representing a stream of AI-generated responses.
     */
    @Override
    public Flux<String> streamAiResponse(String prompt) {
        return chatClient.prompt(prompt).stream().content();
    }
}
