package com.ai.ollama.backend.controller;

import com.ai.ollama.backend.service.AiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/askAi")
    public ResponseEntity<String> askAi(@RequestParam(value = "prompt", required = false, defaultValue = "How can you help me?") String prompt) {
        return ResponseEntity.ok(aiService.askAi(prompt));
    }

    @GetMapping("/askAi/stream")
    public Flux<String> askAiStream(@RequestParam(value = "prompt", required = false, defaultValue = "How can you help me?") String prompt) {
        return aiService.streamAiResponse(prompt);
    }
}
