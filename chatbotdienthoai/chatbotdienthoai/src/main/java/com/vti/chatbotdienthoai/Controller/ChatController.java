package com.vti.chatbotdienthoai.Controller;
import com.vti.chatbotdienthoai.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> body) {
        String message = body.get("message");
        String reply = chatService.handleChat(message);
        return Map.of("reply", reply);
    }
}
