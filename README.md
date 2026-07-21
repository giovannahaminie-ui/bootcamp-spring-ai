# bootcamp-spring-ai

Projeto base de estudo de **Java + Spring Boot + Spring AI**, feito durante meu bootcamp de Bootcamp NTT DATA: Backend Java com Spring AI, vindo de uma base anterior em Python/Flask.

A aplicação sobe uma API REST simples com dois endpoints: um de teste (`/ping`) e um que conversa com um modelo de IA (`/chat`), usando o [Spring AI](https://docs.spring.io/spring-ai/reference/) para abstrair a integração com o modelo.

## Estrutura

```
src/main/java/com/giovanna/bootcampspringai/
├── BootcampSpringAiApplication.java   # ponto de entrada da aplicação
├── controller/ChatController.java     # rotas HTTP (recebe as requisições)
└── service/ChatService.java           # regra de negócio / chamada ao modelo de IA
src/main/resources/application.properties  # configuração da aplicação
src/test/java/...                      # testes
pom.xml                                # dependências do projeto (Maven)
```

## Como funciona

1. O cliente acessa `/chat?mensagem=...`
2. `ChatController` recebe a requisição e repassa para `ChatService`
3. `ChatService` usa o `ChatClient` (Spring AI) para falar com o modelo de IA
4. A resposta do modelo volta como texto simples

O projeto usa o **Ollama** como provedor de IA, que roda um modelo (`llama3.2`) localmente, sem custo e sem precisar de API key, ideal para estudo e testes (como esse).

## Pré-requisitos

1. **JDK 21** instalado (`java -version` pra conferir)
2. **Maven** instalado e no PATH (`mvn -version` pra conferir)
3. **[Ollama](https://ollama.com/download)** instalado, com o modelo baixado:
   ```bash
   ollama pull llama3.2
   ```

## Rodando localmente

```bash
mvn spring-boot:run
```

Depois, com o servidor rodando, acesse pelo navegador:
- `http://localhost:8080/ping` → deve responder `pong` (Primeiro teste)
- `http://localhost:8080/chat?mensagem=Oi` → resposta do modelo de IA (Teste da mensagem)

## Trocando para outro provedor de IA

O projeto usa o starter do Ollama, mas o Spring AI segue o mesmo padrão para outros provedores (OpenAI, Anthropic, Codex, etc). Basta trocar, no `pom.xml`, a dependência `spring-ai-starter-model-ollama` pela equivalente do provedor desejado (ex: `spring-ai-starter-model-anthropic`), e ajustar as propriedades correspondentes em `application.properties`.

## Evidências de execução

Como o projeto depende do Ollama rodando localmente, seguem prints comprovando a aplicação funcionando de ponta a ponta:

**Aplicação subindo com sucesso:**
![Aplicação iniciando](Comando - mvn spring-bootrun)

**Endpoint `/ping` respondendo:**
![Endpoint ping](Comando - httplocalhost8080ping)

**Endpoint `/chat` conversando com o modelo:**
![Endpoint chat](Comando - chatmensagem)

## Projeto para subir no GitHub

```bash
git init
git add .
git commit -m "Projeto base: Spring Boot + Spring AI + Ollama"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/bootcamp-spring-ai.git
git push -u origin main
```
