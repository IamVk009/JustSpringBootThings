package com.ai.ollama.backend.service;

import reactor.core.publisher.Flux;

public interface AiService {

    String askAi(String prompt);

    Flux<String> streamAiResponse(String prompt);
}
