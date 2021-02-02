package com.bangkoklab.chatServer.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class SocketHandler extends TextWebSocketHandler {
	List<HashMap<String, Object>> rls = new ArrayList<>();
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		//메시지 발송
		String msg = message.getPayload();
		JSONObject obj = JsonToObjectParser(msg);
		
		String roomNum = (String)obj.get("roomNumber");
		HashMap<String, Object> temp = new HashMap<String, Object>();
		if(rls.size() > 0) {
			for(int i =0;i <rls.size();i++) {
				String roomNumber = (String)rls.get(i).get("roomNumber");
				
				if(roomNumber.equals(roomNum)) {
					temp = rls.get(i);
					break;
				}
			}
			
			
			for(String key : temp.keySet()) {
				if(key.equals("roomNumber")){
					continue;
				}
				System.out.println("---------------------");
				System.out.println("roomNumber : " + obj.get("roomNumber"));
				System.out.println("roomName : " + obj.get("roomName"));
				System.out.println("userName : " + obj.get("userName"));
				System.out.println("msg : " + obj.get("msg"));
				System.out.println("---------------------");
				
				WebSocketSession wss = (WebSocketSession) temp.get(key);
				if(wss != null) {
					try {
						wss.sendMessage(new TextMessage(obj.toJSONString()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//소켓 연결
		super.afterConnectionEstablished(session);
		boolean flag = false;
		String url = session.getUri().toString();
		System.out.println(url);
		String roomNumber = url.split("/chating/")[1];
		int idx = rls.size();
		if(rls.size() > 0) {
			for(int i=0; i<rls.size(); i++) {
				String roomNum = (String) rls.get(i).get("roomNumber");
			
				if(roomNum.equals(roomNumber)) {
					flag = true;
					idx = i;
					break;
				}
			}
		}
		if(flag) {
			HashMap<String, Object> map = rls.get(idx);
			map.put(session.getId(), session);
		}else {
			HashMap<String,Object> map = new HashMap<String, Object>();
			
			map.put("roomNumber", roomNumber);
			map.put(session.getId(), session);
			rls.add(map);
		}
		
		
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		obj.put("sessionId",session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//소켓 종료
		if(rls.size() > 0) { //소켓이 종료되면 해당 세션값들을 찾아서 지운다.
			for(int i=0; i<rls.size(); i++) {
				rls.get(i).remove(session.getId());
			}
		}
		super.afterConnectionClosed(session, status);
	}
	
	//Json 파일이 들어오면 파싱
	// 파라미터 : json -> simpleJson의 파서 이용 -> JsonObject로 파싱처리
	private static JSONObject JsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
