# Demo Spring AI

## Descrição
Este projeto é uma demonstração de integração do Spring Boot com serviços de IA, utilizando o Spring AI. A aplicação fornece uma API REST que permite interagir com modelos de IA da OpenAI e Ollama para processamento de prompts de chat.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring AI
- Docker e Docker Compose
- OpenAI API
- Ollama (modelo Mistral)

## Estrutura do Projeto
O projeto segue uma arquitetura de camadas típica de aplicações Spring:
- **Controller**: Gerencia os endpoints da API REST
- **Service**: Contém a lógica de negócios e integração com os modelos de IA
- **DTO**: Objetos de transferência de dados para requisições e respostas

## Endpoints da API
A aplicação expõe dois endpoints principais:

1. **POST /ollama**
   - Processa prompts usando o modelo Mistral via Ollama
   - Corpo da requisição: `{ "promptMessage": "sua mensagem aqui" }`

2. **POST /open-ai**
   - Processa prompts usando o modelo GPT-4-1-mini via OpenAI
   - Corpo da requisição: `{ "promptMessage": "sua mensagem aqui" }`

## Configuração e Execução

### Pré-requisitos
- Java 21 ou superior
- Docker e Docker Compose
- Chave de API da OpenAI

### Variáveis de Ambiente
- `OPENAI_API_KEY`: Sua chave de API da OpenAI

### Executando com Docker
1. Clone o repositório
2. Configure a variável de ambiente `OPENAI_API_KEY`
3. Execute o comando:
   ```
   docker-compose up -d
   ```
4. A aplicação estará disponível em `http://localhost:8080`

### Executando Localmente
1. Clone o repositório
2. Configure a variável de ambiente `OPENAI_API_KEY`
3. Inicie o container Ollama:
   ```
   docker-compose up -d
   ```
4. Execute a aplicação Spring Boot:
   ```
   ./mvnw spring-boot:run
   ```
5. A aplicação estará disponível em `http://localhost:8080`

## Uso
Exemplo de requisição usando curl:

```bash
# Usando Ollama
curl -X POST http://localhost:8080/ollama \
  -H "Content-Type: application/json" \
  -d '{"promptMessage": "Explique o que é Spring Boot"}'

# Usando OpenAI
curl -X POST http://localhost:8080/open-ai \
  -H "Content-Type: application/json" \
  -d '{"promptMessage": "Explique o que é Spring Boot"}'
```

## Personalização
O comportamento dos modelos de IA pode ser ajustado modificando os parâmetros nas classes de serviço:
- `OpenAiServiceImpl.java`: Configurações para o modelo OpenAI
- `OllamaAiServiceImpl.java`: Configurações para o modelo Ollama

## Licença
Este projeto é distribuído sob a licença MIT.