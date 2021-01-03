package board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.dto.BoardDto;

public class ListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dto = dao.list();
		request.setAttribute("list", dto);
		
		//이름은 list , 값은 dto
		
		
	}

	
}
