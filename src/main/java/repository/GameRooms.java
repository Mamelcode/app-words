package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import data.GameRoom;


public class GameRooms extends DAO {
	
	public static int create(String id) {
		SqlSession session = factory.openSession(true);
		try {
			return session.insert("gameRooms.create", id);
		}finally {
			session.close();
		}
	}
	
	public static List<GameRoom> readAll() {
		SqlSession session = factory.openSession(true);
		try {
			return session.selectList("gameRooms.readAll");
		} finally {
			session.close();
		}
	}
}
