package fit.iuh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.Daos.PersonDaos;
import fit.iuh.Entities.Person;

/**
 * Servlet implementation class AddPerson
 */
@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDaos personDaos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPerson() {
        super();
        // TODO Auto-generated constructor stub
        personDaos = new PersonDaos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =  request.getParameter("Name");
		String country = request.getParameter("Country");
		Person p = new Person(name, country);
		boolean result = personDaos.addPerson(p);
		if (result) {
			response.getWriter().println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Person Mangement</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>Add success</h1>" + 
					"	<a href=\"./\">back</a>" + 
					"</body>" + 
					"</html>"); 
		}
		else {
			response.getWriter().println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Person Mangement</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>Add faild</h1>" + 
					"	<a href= \"./\">back</a>" + 
					"</body>" + 
					"</html>");
		}
		
	}

}
