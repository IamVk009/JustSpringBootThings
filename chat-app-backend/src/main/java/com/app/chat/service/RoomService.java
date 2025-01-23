package com.app.chat.service;

import com.app.chat.entity.Message;
import com.app.chat.entity.Room;

import java.util.List;

public interface RoomService {

    Room createRoom(String roomId);

    Room joinRoom(String roomId);

    List<Message> getMessages(String roomId);
}
