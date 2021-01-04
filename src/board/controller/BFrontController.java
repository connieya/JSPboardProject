package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.BCommand;
import board.command.BDeleteCommand;
import board.command.BModifyCommand;
import board.command.ContentCommand;
import board.command.JoinCommand;
import board.command.ListCommand;
import board.command.WriteCommand;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		System.out.println("doget 호출");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
		System.out.println("dopost 호출");
	}
	
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle 응답");
		
		request.setCharacterEncoding("utf-8");
		
		String viewpage = null; //어떤 페이지를 보여줄건지 확인하는 값
		BCommand bcommand = null; //dao에 작업을 전달하는??
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		
		
		if(com.equals("/list.do")) {
			bcommand = new ListCommand();
			bcommand.execute(request, response);
			viewpage = "board.jsp";
			
		}else if(com.equals("/write.do")) {
			bcommand = new WriteCommand();
			bcommand.execute(request, response);
			viewpage = "list.do";
		}else if(com.equals("/content_view.do")) {
			bcommand = new ContentCommand();
			bcommand.execute(request, response);
			viewpage ="content_view.jsp";
		}else if(com.equals("/modify.do")) {
			bcommand = new BModifyCommand();
			bcommand.execute(request, response);
			viewpage ="content_view.do";
		}else if(com.equals("/delete.do")) {
			bcommand = new BDeleteCommand();
			bcommand.execute(request, response);
			viewpage = "list.do";
		}else if(com.equals("/authentication.do")){
			bcommand = new JoinCommand();
			bcommand.execute(request, response);
			viewpage = "delete.do";
		}
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);
	
	}

}
