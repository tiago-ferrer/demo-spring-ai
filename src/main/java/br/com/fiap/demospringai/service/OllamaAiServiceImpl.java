package br.com.fiap.demospringai.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service("ollamaAiService")
class OllamaAiServiceImpl extends AiService {

    private final OllamaChatModel ollamaChatModel;

    OllamaAiServiceImpl(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @Override
    public String call(String promptMessage) {

        final Prompt prompt = new Prompt(getMessages(promptMessage),
                OllamaOptions.builder()
                        .model(OllamaModel.MISTRAL)
                        .temperature(0.4)
                        .build());

        final ChatResponse chatResponse = this.ollamaChatModel.call(prompt);

        return chatResponse.getResult().getOutput().getText();
    }
}
