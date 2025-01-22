package com.app.chat.service.impl;

import com.app.chat.entity.Room;
import com.app.chat.repositories.RoomRepository;
import com.app.chat.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room != null) {
            throw new RuntimeException("Room with ID : " + roomId + " Already Exists");
        }
        Room newRoom = new Room();
        newRoom.setRoomId(roomId);
        return roomRepository.save(newRoom);
    }

    @Override
    public Room joinRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new RuntimeException("Room with ID = " + roomId + " does not exist.");
        }
        return room;
    }
}
