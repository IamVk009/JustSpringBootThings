package com.app.chat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String roomId;
    private List<Message> messages = new ArrayList<>();

    public Room() {
    }

    public Room(String id, String roomId, List<Message> messages) {
        this.id = id;
        this.roomId = roomId;
        this.messages = messages;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
