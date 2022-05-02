package project9;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;

public class BidForm extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("itemid");
		String itemName = request.getParameter("itemname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String amount = request.getParameter("bid");
		String inc = request.getParameter("true");
		
		out.println("<h1>Bid Submitted</h1>");
		out.println("<table border='1' style='text-align: center;background-color: #fff5ab;'>");
		out.println("<tr>");
		out.print("<td style='color:#fff; background-color: #000'>" + itemName + "</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.print("<td>Item Id: " + id + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.print("<td>Name: " + name + "</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.print("<td>Email Address: "+ email + "</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.print("<td>Bidding Price: " + amount + "</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.print("<td>Auto Incriment:" + inc + " </td>");
		out.println("<tr>");
		out.println("<table>");
		
		out.flush();
		out.close();
	}
}
