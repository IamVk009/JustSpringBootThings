package com.app.chat.controller;

import com.app.chat.entity.Message;
import com.app.chat.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        return new ResponseEntity<>(roomService.createRoom(roomId), HttpStatus.CREATED);
    }

    @GetMapping("/join/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        return new ResponseEntity<>(roomService.joinRoom(roomId), HttpStatus.OK);
    }

    @GetMapping("/messages/{roomId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getMessages(roomId));
    }
}
