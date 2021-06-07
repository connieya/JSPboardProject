package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardWriteController implements Controller {
	BoardDao boardDao;
	
	public BoardWriteController setBoadDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	@Override
	public String  execute(Map<String, Object> model) throws Exception {

		if (model.get("board") == null) {
			return "/board/BoardForm.jsp";
		}else {
			

		Board board = (Board) model.get("board");

		boardDao.글쓰기(board);

		return "redirect:list.do";
	}

	}

}
