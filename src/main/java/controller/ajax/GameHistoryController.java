package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.GameData;
import repository.GameDatas;

@WebServlet("/ajax/game/history")
public class GameHistoryController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// gameRoom 화면에서 최신데이터만 갱신을 시키고자 할때 보내게 될 ajax 요청 처리용
		String roomId = req.getParameter("roomId");
		
		List<GameData> li = GameDatas.readByRoomId(roomId);
		Gson gson = new Gson();
		
		Map map = new HashMap<>();
		map.put("item", li);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(gson.toJson(map));
		
	}
}
