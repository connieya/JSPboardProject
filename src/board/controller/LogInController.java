package board.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import board.dao.UserDao;
import board.vo.User;

public class LogInController implements Controller {
	
	UserDao userDao;
	
	public LogInController setUserDao(UserDao userDao){
		this.userDao = userDao;
		return this;
	
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		if(model.get("loginInfo") == null) {
			return "/auth/login.jsp";
		}else {
			System.out.println("호출``");
			User loginInfo = (User) model.get("loginInfo");
			User user= userDao.login(loginInfo.getId(), loginInfo.getPassword());
			 System.out.println("user: "+user);
			if(user != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("user", user);
			return "redirect:/board/index.jsp";
			}else {
				return "/auth/LoginFail.jsp";
			}
		}
	}

}
