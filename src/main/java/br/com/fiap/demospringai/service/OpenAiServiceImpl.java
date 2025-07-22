package br.com.fiap.demospringai.service;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("openAiService")
class OpenAiServiceImpl extends AiService {

    private final OpenAiChatModel openAiChatModel;


    OpenAiServiceImpl(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public String call(String promptMessage) {
        List<Message> generalInstructions = getMessages(promptMessage);

        final Prompt prompt = new Prompt(generalInstructions,
                OpenAiChatOptions.builder()
                        .model(OpenAiApi.ChatModel.GPT_4_1_MINI)
                        .temperature(0.4)
                        .build());

        final ChatResponse chatResponse = this.openAiChatModel.call(prompt);

        return chatResponse.getResult().getOutput().getText();
    }


}
