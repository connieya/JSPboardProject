package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;


public class JoinCommand implements BCommand {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("JoinCommand 호출");
		String password = request.getParameter("password");
		String no = request.getParameter("no");
		System.out.println("no : "  + no);
		System.out.println("password : " +password);
		BoardDao dao = new BoardDao();
		
		int result = dao.삭제인증(no , password);
		if(result == 1) {
			System.out.println("삭제");
		}
		
		
	
		
	}
	

}
