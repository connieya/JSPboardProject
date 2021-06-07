package board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import board.dao.UserDao;
import board.util.Srcipt;

public class UserDeleteController implements Controller {

	UserDao userDao;
	
	public UserDeleteController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int no = (Integer)model.get("no");
		int result = userDao.delete(no);
		if(result ==-1) {
			Srcipt.back("회원탈퇴 실패", (HttpServletResponse) model);
			
		}else {
			return "redirect:/index.jsp";
		}
		return null;
		
	}

}
