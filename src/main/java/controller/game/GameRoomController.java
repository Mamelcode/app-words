package controller.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.GameData;
import repository.GameDatas;

@WebServlet("/game/room")
public class GameRoomController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 특정방에 입장했을때를 처리하는 곳
		req.setCharacterEncoding("utf-8");
		
		String roomId = req.getParameter("roomId"); // 방 아이디를 받아온다.
		
		List<GameData> li = GameDatas.readByRoomId(roomId);
		
		req.setAttribute("datas", li);
		
	}
}
