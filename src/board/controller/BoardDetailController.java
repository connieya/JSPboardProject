package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao boardDao = (BoardDao) request.getAttribute("boardDao");
		
		int no = Integer.parseInt((String) request.getAttribute("no"));
		
		Board board = boardDao.글상세보기(no);
		request.setAttribute("boardDetail", board);
		
		return "/board/boardDetail.jsp";
		
		
	}

}
