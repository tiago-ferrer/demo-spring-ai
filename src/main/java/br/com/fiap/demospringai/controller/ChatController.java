package br.com.fiap.demospringai.controller;

import br.com.fiap.demospringai.dto.RequestChat;
import br.com.fiap.demospringai.dto.ResponseChat;
import br.com.fiap.demospringai.service.AiService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final AiService aiServiceOllama;
    private final AiService aiServiceOpenAi;

    public ChatController(@Qualifier("ollamaAiService") AiService aiServiceOllama,
                          @Qualifier("openAiService") AiService aiServiceOpenAi) {
        this.aiServiceOllama = aiServiceOllama;
        this.aiServiceOpenAi = aiServiceOpenAi;
    }

    @PostMapping("/ollama")
    public ResponseEntity<ResponseChat> chatOllama(@RequestBody RequestChat requestChat) {
        final String chatResponse = aiServiceOllama.call(requestChat.getPromptMessage());
        return ResponseEntity.ok(new ResponseChat(chatResponse));
    }

    @PostMapping("/open-ai")
    public ResponseEntity<ResponseChat> chatOpenAi(@RequestBody RequestChat requestChat) {
        final String chatResponse = aiServiceOpenAi.call(requestChat.getPromptMessage());
        return ResponseEntity.ok(new ResponseChat(chatResponse));
    }
}
