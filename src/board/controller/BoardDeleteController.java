package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;

public class BoardDeleteController implements Controller {
	BoardDao boardDao;
	
	public BoardDeleteController setBoadDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		
		int bno = Integer.parseInt((String) model.get("no"));
		
		boardDao.글삭제하기(bno);
		
		return "redirect:list.do";
	
		
	}

}
