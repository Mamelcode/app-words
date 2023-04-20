package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import data.GameData;

@SuppressWarnings("rawtypes")
public class GameDatas extends DAO{
	
	
	public static int create(Map map) {
		SqlSession session = factory.openSession(true);
		try {
			return session.insert("gameDatas.create", map);
		}finally {
			session.close();
		}
	}
	
	public static List<GameData> readByRoomId(String roomId) {
		SqlSession session = factory.openSession(true);
		try {
			return session.selectList("gameDatas.readByRoomId", roomId);
		}finally {
			session.close();
		}
	}
	
	public static GameData readByWord(Map map) {
		SqlSession session = factory.openSession(true);
		try {
			return session.selectOne("gameDatas.readByWord", map);
		}finally {
			session.close();
		}
	}
	
	public static GameData readLatest(String roomId) {
		SqlSession session = factory.openSession(true);
		try {
			return session.selectOne("gameDatas.readLatest", roomId);
		}finally {
			session.close();
		}
	}
	
	
}
