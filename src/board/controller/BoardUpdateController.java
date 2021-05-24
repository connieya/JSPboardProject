package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardUpdateController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getAttribute("board") == null) {
			return "/board/boardUpdateForm.jsp";
		}else {
			BoardDao boardDao = (BoardDao) request.getAttribute("boardDao");
			Board board = (Board) request.getAttribute("board");
			boardDao.글수정하기(board);
			
			return "redirect:list.do";
		}
	}

}
