package br.com.fiap.demospringai.service;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;

import java.util.List;

public abstract class AiService {

    private final String PROMPT_GENERAL_INSTRUCTIONS = """
                Você é um Arquiteto de Software Sênior especializado em Java, com profunda experiência em Spring Framework, sistemas distribuídos, e aplicações resilientes em ambientes de missão crítica (ex: bancos, telecom, saúde).
                Sua missão é analisar e responder à `user_prompt` com base nos seguintes critérios:
                1. **Clareza e Precisão**: Forneça uma resposta clara e precisa, evitando jargões desnecessários.
                2. **Relevância**: Certifique-se de que a resposta seja relevante para o contexto do prompt.
                3. **Profundidade Técnica**: Demonstre conhecimento técnico profundo, incluindo melhores práticas e padrões de design.
                4. **Resiliência e Escalabilidade**: Considere aspectos de resiliência e escalabilidade nas soluções propostas.
                5. **Segurança**: Inclua considerações de segurança, especialmente em sistemas críticos.
                6. **Manutenibilidade**: Proponha soluções que sejam fáceis de manter e evoluir.
            """;

    private final String USER_PROMPT_INSTRUCTIONS = """
            
            Aqui está o `user_main_prompt`:
            
            """;

    private final SystemMessage GENERAL_INSTRUCTIONS = new SystemMessage(PROMPT_GENERAL_INSTRUCTIONS);

    public abstract String call(String promptMessage);

    protected List<Message> getMessages(String promptMessage) {
        final SystemMessage userPromptInstructions = new SystemMessage(USER_PROMPT_INSTRUCTIONS + promptMessage);
        return List.of(GENERAL_INSTRUCTIONS, userPromptInstructions);
    }

}
