package data;

import java.util.Date;

public class GameData {
	String id;
	String roomId;
	String word;
	String talker;
	
	Date wirted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker;
	}

	public Date getWirted() {
		return wirted;
	}

	public void setWirted(Date wirted) {
		this.wirted = wirted;
	}
}
