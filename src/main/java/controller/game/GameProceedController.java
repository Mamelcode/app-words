package controller.game;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.OpenDicAPI;
import data.GameData;
import data.search.SearchResult;
import repository.GameDatas;
import util.WordValidator;

@WebServlet("/game/proceed")
public class GameProceedController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// 사용자가 보내준 단어를 등록시키는 작업
		String roomId = req.getParameter("roomId");
		String word = req.getParameter("word");
		String talker = req.getRemoteAddr(); // 아이피

		int code = WordValidator.execute(roomId, word);

		if (code == 0) {
			Map<String, Object> map = new HashMap<>();
			map.put("roomId", roomId);
			map.put("word", word);
			map.put("talker", talker);

			int r = GameDatas.create(map);
		}else {
			
		}
	}
}
