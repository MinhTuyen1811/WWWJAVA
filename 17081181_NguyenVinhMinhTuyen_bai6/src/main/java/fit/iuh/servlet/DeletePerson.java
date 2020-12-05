package fit.iuh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import fit.iuh.Daos.PersonDaos;

/**
 * Servlet implementation class DeletePerson
 */
@WebServlet("/DeletePerson")
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDaos personDaos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePerson() {
        super();
        // TODO Auto-generated constructor stub
        personDaos= new PersonDaos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		ObjectId id = new ObjectId(str);
		boolean result = personDaos.deletePerson(id);
		if (result) {
			response.getWriter().println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Person Mangement</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>Delete success</h1>" + 
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
					"	<h1>Delete faild</h1>" + 
					"	<a href= \"./\">back</a>" + 
					"</body>" + 
					"</html>");
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
