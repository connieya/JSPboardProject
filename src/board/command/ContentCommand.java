package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class ContentCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("contentCommand 호출");
		String no = request.getParameter("no");
		
		BoardDao dao = new BoardDao();
		Board dto = dao.글상세보기(no);
		request.setAttribute("content_view", dto);
	}

}
