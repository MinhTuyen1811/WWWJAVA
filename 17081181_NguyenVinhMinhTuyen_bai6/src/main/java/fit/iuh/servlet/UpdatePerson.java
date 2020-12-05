package fit.iuh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import fit.iuh.Daos.PersonDaos;
import fit.iuh.Entities.Person;

/**
 * Servlet implementation class UpdatePerson
 */
@WebServlet("/UpdatePerson")
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDaos personDaos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerson() {
        super();
        // TODO Auto-generated constructor stub
        personDaos = new PersonDaos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Person p = personDaos.findPerson(new ObjectId(id));
		response.setCharacterEncoding("UTF-8");
		PrintWriter out  = response.getWriter();
		out.println("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>Person Mangement</title>" + 
				"</head>" + 
				"<body>" + 
				"	<h1>Update Person</h1>" + 
				"	<a href=\"./\">back</a>" + 
				"	<form action=\"UpdatePerson\" method=\"post\">" + 
				"		<input type=\"hidden\", name=\"id\" value=\""+id+"\">" + 
				"		<label>Name:</label>" + 
				"		<input type=\"text\" name=\"name\"value=\""+p.getName()+"\"></br>" + 
				"		<label>Country:</label>" + 
				"		<input type=\"text\" name=\"country\"value=\""+p.getCountry()+"\"></br>" + 
				"		<button type=\"submit\" >Save person</button>" + 
				"	</form>" + 
				"</body>" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		ObjectId id = new ObjectId(str);
		String name =  request.getParameter("Name");
		String country = request.getParameter("Country");
		Person p = new Person(id,name, country);//
		boolean result = personDaos.updatePerson(p);
		if (result) {
			response.getWriter().println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Person Mangement</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>Update success</h1>" + 
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
					"	<h1>Update faild</h1>" + 
					"	<a href= \"./\">back</a>" + 
					"</body>" + 
					"</html>");
		}
		
	}

	}


