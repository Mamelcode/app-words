package controller.game;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.GameRooms;

@WebServlet("/game/create")
public class GameCreateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 방 개설을 요구햇을때 처리할 컨트롤러
		
		// 방을 만들려면 ID가 필요한대, 이걸 파람으로 전달 안받고
		// UUID를 써서 만든다
		String id = UUID.randomUUID().toString().split("-")[0];
		int r = GameRooms.create(id);
		if(r == 1) {
			resp.sendRedirect(id);
		}else {
			
		}
		
	}
}
