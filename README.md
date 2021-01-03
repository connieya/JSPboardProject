# JSP


---------------------------


## FrontController

```
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
			bcommand = new JoinCommand();
			bcommand.execute(request, response);
			viewpage = "index.jsp";
			
		}else if(com.equals("/write.do")) {
			bcommand = new ListCommand();
			bcommand.execute(request, response);
			viewpage = "write.jsp";
		}else if(com.equals("/content_view.do")) {
			bcommand = new ContentCommand();
			bcommand.execute(request, response);
			viewpage ="content_view.jsp";
		}else if(com.equals("/modify.do")) {
			bcommand = new BModifyCommand();
			bcommand.execute(request, response);
			viewpage ="list.do";
		}else if(com.equals("delete.do")) {
			bcommand = new BDeleteCommand();
			bcommand.execute(request, response);
			viewpage = "list.do";
		}
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);
	
	}

}

```

.do로 끝나는 요청을 다 받는 frontcontroller

그리고 각 각의 요청을 command 에서 수행


### 글쓰기

write.jsp / form 태그 -> write.do로 요청 <br/>
BFrontController.java [ @WebServlet("*.do") do로 오는 요청 다 받음] 에서 응답 <br/>
get , post 요청 다 받는 Dohandle 로직 수행 

```
(com.equals("/write.do")) {
			bcommand = new WriteCommand();
			bcommand.execute(request, response);
			viewpage = "board.jsp";
```
WriteCommand.java

write.jsp 에서 보낸 데이터 값
request.getParameter로 받음

그리고 DB랑 연동하기 위해 BoardDAO.java 호출

---------------------------------------------------------- 

### 글 목록 보기

`header.jsp`

```
 <a class="nav-item nav-link " href="list.do">게시판</a>
```

`BFrontController.java`

```
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	if(com.equals("/list.do")) {
			bcommand = new ListCommand();
			bcommand.execute(request, response);
			viewpage = "board.jsp";
	
```

`ListCommand.java`

```
public class ListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dto = dao.list();
		request.setAttribute("list", dto);
		
		//이름은 list , 값은 dto
		
		
	}

	
}
```
`BoardDao.java list메서드`  호출

BoardDto를 ArrayList로 해서 데이터 값 넣어줌




-------------------------------------

### 글 상세보기 페이지

```
else if(com.equals("/content_view.do")) {
			bcommand = new ContentCommand();
			bcommand.execute(request, response);
			viewpage ="content_view.jsp";
			
			
			
		}
```
FrontController에 요청이 들어왔다.
