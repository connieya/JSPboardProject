package board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardDetailController implements Controller {
	BoardDao boardDao;
	
	public BoardDetailController setBoadDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		
		int no = Integer.parseInt((String) model.get("no"));
		
		Board board = boardDao.글상세보기(no);
		model.put("board", board);
		
		return "/board/boardDetail.jsp";
		
		
	}

}
