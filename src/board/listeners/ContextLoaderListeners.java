package board.listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import board.dao.BoardDao;
import board.dao.UserDao;

@WebListener
public class ContextLoaderListeners implements ServletContextListener {
	Connection conn;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
		
			InitialContext initialContext = new InitialContext();
			DataSource ds  = (DataSource) initialContext.lookup(
					"java:comp/env/jdbc/cony");
			
			BoardDao boardDao = new BoardDao();
			boardDao.setDataSource(ds);
			
			UserDao userDao = new UserDao();
			userDao.setDataSource(ds);
			
			sc.setAttribute("boardDao", boardDao);
			sc.setAttribute("userDao", userDao);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
