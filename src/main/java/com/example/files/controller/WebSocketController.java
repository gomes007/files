package com.example.files.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ws")
@CrossOrigin(origins = "http://localhost:3000")
public class WebSocketController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        return message;
    }
}
