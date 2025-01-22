package com.app.chat.service;

import com.app.chat.entity.Room;

public interface RoomService {

    Room createRoom(String roomId);

    Room joinRoom(String roomId);
}
