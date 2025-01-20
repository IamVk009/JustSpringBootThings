package com.app.chat.repositories;

import com.app.chat.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    // Get Room using RoomId
    Room findByRoomId(String roomId);
}
