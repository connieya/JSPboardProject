package board.controller;

import java.util.Map;

import board.bind.DataBinding;
import board.dao.BoardDao;
import board.vo.Board;

public class BoardAddController implements Controller, DataBinding {
	BoardDao boardDao;
	
	public BoardAddController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"board", board.vo.Board.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if (model.get("board") ==null) {
			return "/board/BoardForm.jsp";
		}else {
			Board board = (Board) model.get("board");
			boardDao.글쓰기(board);
			return "redirect:/board/list.do";
		}
		
	}

}
