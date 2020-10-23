package board.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.MemberDao;
import board.dto.MemberVo;


public class JoinCommand implements BCommand {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		
		MemberVo vo = dao.insert();
		request.setAttribute("insert", vo);
	}
	

}
