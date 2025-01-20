package com.app.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String sender;
    private String messageContent;
    private LocalDateTime timeStamp;

    public Message(String sender, String messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
        this.timeStamp = LocalDateTime.now();
    }
}
