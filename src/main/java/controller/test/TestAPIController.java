package controller.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.OpenDicAPI;
import data.search.SearchResult;

@WebServlet("/test/api")
public class TestAPIController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		
		SearchResult result = OpenDicAPI.search(q==null ? "행복" : q);
		
		System.out.println(result.getChannel().getItem()[0].getSense()[0].getDefinition());
	}
}
