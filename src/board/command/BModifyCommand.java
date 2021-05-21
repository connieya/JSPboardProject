package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String no = request.getParameter("no");
		BoardDao dao = new BoardDao();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("no: " +no +"title : " +title+" content: " + content);
		int number = Integer.parseInt(no);
		Board dto = new Board();
		dto.setNo(number);
		dto.setTitle(title);
		dto.setContent(content);
		
		dao.글수정하기(dto);
	}

}
