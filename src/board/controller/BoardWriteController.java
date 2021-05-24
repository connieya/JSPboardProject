package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardWriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request.getAttribute("board") == null) {
			return "/board/BoardForm.jsp";
		}else {
			
		BoardDao boardDao = (BoardDao) request.getAttribute("boarDao");

		Board board = (Board) request.getAttribute("board");

		boardDao.글쓰기(board);

		return "redirect:list.do";
	}

	}

}
