package board.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

			System.out.println("DeleteCommand 호출");
		String no = request.getParameter("no");
		
		
		System.out.println("no : "+no);
	
		BoardDao dao = new BoardDao();
		 dao.글삭제하기(no);
		
		
	}

}
