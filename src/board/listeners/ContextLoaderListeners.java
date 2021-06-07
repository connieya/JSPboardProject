package board.listeners;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import board.controller.BoardDeleteController;
import board.controller.BoardListController;
import board.controller.BoardUpdateController;
import board.controller.LogInController;
import board.controller.LogOutController;
import board.controller.UserDeleteController;
import board.controller.UserJoinController;
import board.dao.BoardDao;
import board.dao.UserDao;

@WebListener
public class ContextLoaderListeners implements ServletContextListener {
	Connection conn;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("왔니??????????");
		try {
			ServletContext sc = event.getServletContext();
		
			InitialContext initialContext = new InitialContext();
			DataSource ds  = (DataSource) initialContext.lookup(
					"java:comp/env/jdbc/cony");
			
			System.out.println("확인!!");
			BoardDao boardDao = new BoardDao();
			boardDao.setDataSource(ds);
			
			UserDao userDao = new UserDao();
			userDao.setDataSource(ds);
			
			sc.setAttribute("/auth/login.do", new LogInController().setUserDao(userDao));
			sc.setAttribute("/auth/logout.do", new LogOutController());
			sc.setAttribute("/board/list.do", new BoardListController().setBoadDao(boardDao));
			sc.setAttribute("/board/add.do", new BoardListController().setBoadDao(boardDao));
			sc.setAttribute("/board/update.do", new BoardUpdateController().setBoadDao(boardDao));
			sc.setAttribute("/board/delete.do", new BoardDeleteController().setBoadDao(boardDao));
			sc.setAttribute("/user/join.do", new UserJoinController().setUserDao(userDao));
			sc.setAttribute("/user/delete.do", new UserDeleteController().setUserDao(userDao));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
