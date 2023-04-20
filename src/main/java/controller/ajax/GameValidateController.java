package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import api.OpenDicAPI;
import data.GameData;
import data.search.SearchResult;
import repository.GameDatas;
import util.WordValidator;

@WebServlet("/ajax/game/validate")
public class GameValidateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 입력하는 단어가 처리가능한건지 확인하는 AJAX 요청을 처리할 곳
		req.setCharacterEncoding("utf-8");
		String roomId = req.getParameter("roomId");
		String word = req.getParameter("word");
		
		int code = WordValidator.execute(roomId, word);
		
		Gson gson = new Gson();
		
		Map result = new HashMap();
		result.put("code", code);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println(gson.toJson(result));
	}
}
