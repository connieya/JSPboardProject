package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.dao.UserDao;
import board.vo.User;


public class UserJoinController implements Controller {

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("user") == null) {
			
			return "/user/joinForm.jsp";
		}else {
			UserDao userDao = (UserDao) request.getAttribute("userDao");
			
			User user = (User) request.getAttribute("user");
			try {
				userDao.join(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "redirect:/index.jsp";
		}
		
	}
	

}
