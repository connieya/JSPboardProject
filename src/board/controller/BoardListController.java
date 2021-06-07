package board.controller;

import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardListController implements Controller {
	BoardDao boardDao;
	
	public BoardListController setBoadDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public String  execute(Map<String, Object> model) throws Exception {

		List<Board> boards =boardDao.list();
		model.put("boards", boards);
		
		return "/board/BoardList.jsp";
		
		
	}

	
}
