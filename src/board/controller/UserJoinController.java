package board.controller;

import java.util.Map;

import board.dao.UserDao;
import board.vo.User;

public class UserJoinController implements Controller {
	UserDao userDao;

	public UserJoinController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;

	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		if (model.get("joinData") == null) {
			return "/user/joinForm.jsp";
		} else {
			User user = (User) model.get("joinData");
			try {
				userDao.join(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/board/index.jsp";
		}

	}

}
