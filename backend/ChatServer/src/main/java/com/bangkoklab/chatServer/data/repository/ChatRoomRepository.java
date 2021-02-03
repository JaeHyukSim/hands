package com.bangkoklab.chatServer.data.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.bangkoklab.chatServer.data.ChatRoom;

@Repository
public class ChatRoomRepository {

 private Map<String, ChatRoom> chatRoomMap;

 @PostConstruct
 private void init() {
     chatRoomMap = new LinkedHashMap<>();
 }

 public List<ChatRoom> findAllRoom() {
	// 채팅방 생성순서 최근 순으로 반환
     List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
     Collections.reverse(chatRooms);
     return chatRooms;
 }

 public ChatRoom findRoomById(String id) {
     return chatRoomMap.get(id);
 }

 public ChatRoom createChatRoom(String roomName) {
     ChatRoom chatRoom = new ChatRoom();
     String roomId = UUID.randomUUID().toString();
     chatRoom.setRoomName(roomName);
     chatRoom.setRoomId(roomId);
     chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
     return chatRoom;
 }
}