package board.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Srcipt {
	public static void back(String msg , HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset-utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();");
		out.println("</script>");
	}

}
