package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao boardDao = (BoardDao) request.getAttribute("boardDao");

		List<Board> boards =boardDao.list();
		request.setAttribute("boards", boards);
		
		return "/board/BoardList.jsp";
		
		
	}

	
}
