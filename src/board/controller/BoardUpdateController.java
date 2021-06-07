package board.controller;

import java.util.Map;

import board.bind.DataBinding;
import board.dao.BoardDao;
import board.vo.Board;

public class BoardUpdateController implements Controller ,DataBinding{
	BoardDao boardDao;
	
	public BoardUpdateController setBoadDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	@Override
	public String  execute(Map<String, Object> model) throws Exception {
		
		if(model.get("board") == null) {
			return "/board/boardUpdateForm.jsp";
		}else {
			Board board = (Board) model.get("board");
			boardDao.글수정하기(board);
			
			return "redirect:list.do";
		}
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class,
				"board" , board.vo.Board.class
		};
	}

}
