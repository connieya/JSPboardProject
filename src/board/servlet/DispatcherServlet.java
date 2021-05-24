package board.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardListController;
import board.controller.BoardUpdateController;
import board.controller.Controller;
import board.controller.UserJoinController;
import board.vo.Board;
import board.vo.User;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		try {
			ServletContext sc = this.getServletContext();

			request.setAttribute("boardDao", sc.getAttribute("boardDao"));
			request.setAttribute("userDao", sc.getAttribute("userDao"));
			Controller pageController = null;
			if ("/user/join.do".equals(servletPath)) {
				pageController = new UserJoinController();
				if (request.getParameter("name") != null) {
					request.setAttribute("user", new User().setId(request.getParameter("id"))
							.setName(request.getParameter("name")).setPassword(request.getParameter("pw")));
				}
			} else if ("/board/update.do".equals(servletPath)) {
				pageController = new BoardUpdateController();
				if (request.getParameter("title") != null) {
					request.setAttribute("board",new Board()
							.setContent(request.getParameter("content"))
							.setTitle(request.getParameter("title")));
				}
			} else if ("/board/list.do".equals(servletPath)) {
				pageController = new BoardListController();
			}

			String viewUrl = pageController.execute(request, response);

			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd =request.getRequestDispatcher(viewUrl);
				rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);

		}

	}

}
