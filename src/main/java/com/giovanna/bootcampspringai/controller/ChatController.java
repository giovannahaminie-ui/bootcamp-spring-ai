package com.giovanna.bootcampspringai.controller;

import com.giovanna.bootcampspringai.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping("/chat")
    public String chat(@RequestParam(defaultValue = "Ola, quem e voce?") String mensagem) {
        return chatService.perguntar(mensagem);
    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
