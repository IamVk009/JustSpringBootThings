package com.app.chat.entity;

import java.time.LocalDateTime;

public class Message {

    private String sender;
    private String messageContent;
    private LocalDateTime timeStamp;

    public Message() {
    }

    public Message(String sender, String messageContent, LocalDateTime timeStamp) {
        this.sender = sender;
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSender() {
        return sender;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Message(String sender, String messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
        this.timeStamp = LocalDateTime.now();
    }
}
