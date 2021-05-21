package board.listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import board.dao.BoardDao;

@WebListener
public class ContextLoaderListeners implements ServletContextListener {
	Connection conn;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);
			
			sc.setAttribute("boardDao", boardDao);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
