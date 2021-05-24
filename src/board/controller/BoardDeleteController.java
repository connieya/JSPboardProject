package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;

public class BoardDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boardDao = (BoardDao) request.getAttribute("boardDao");
		
		int bno = Integer.parseInt((String) request.getAttribute("bno"));
		
		boardDao.글삭제하기(bno);
		
		return "redirect:list.do";
	
		
	}

}
