package board.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class WriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("writeCommand 응답");
		BoardDao dao = new BoardDao();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Board dto = new Board(name,title,content,password);
		  dao.글쓰기(dto);
			
			
	
	}

}
