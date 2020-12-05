package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bai04
 */
@WebServlet("/Bai04")
public class Bai04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//khắc phục lỗi gửi k nhận tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String name= request.getParameter("FirstName")+" "+ request.getParameter("LastName");
		String email= request.getParameter("Email");
		String usn= request.getParameter("Username");
		String psw= request.getParameter("Password");
		String fb= request.getParameter("Facebook");
		String bio= request.getParameter("ShortBio");
		String html="<br>"   + "<html>"    + "<head><meta charset=\"UTF-8\">"  + "<title>Result Page</title>"    + "</head>"  + "<body>"  
		+ "Name: "+ name +"<br>"  + "Username: "+ usn +"<br>" + "Password: "+ psw +"<br>"   + "Email: "+ email +"<br> Facebook URL: "+ fb +"<br>" 
				 
				   + "Short Bio: "+ bio +"<br>"    + "</body>"  + "</html>";  out.println(html); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
