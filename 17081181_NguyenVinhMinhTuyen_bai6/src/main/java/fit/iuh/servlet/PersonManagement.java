package fit.iuh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.Daos.PersonDaos;
import fit.iuh.Entities.Person;

/**
 * Servlet implementation class PersonManagement
 */
@WebServlet("/")
public class PersonManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDaos personDaos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonManagement() {
		super();
		// TODO Auto-generated constructor stub
		personDaos = new PersonDaos();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String html = "<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>Person Mangement</title>" + 
				"</head>" + 
				"<body>" + 
				"	<h1>Person management</h1>" + 
				"	<form action=\"AddPerson\"method=\"post\">" + 
				"		<label>Name:</label>" + 
				"		<input type=\"text\" name=\"Name\"></br>" + 
				"		<label>Country:</label>" + 
				"		<input type=\"text\" name=\"Country\"></br>" + 
				"		<button type=\"submit\" >Add person</button>" + 
				"	</form>" + 
				"	<table>" + 
				"		<thead>" + 
				"			<tr>" + 
				"				<th>ID</th>" + 
				"				<th>Name</th>" + 
				"				<th>Country</th>" + 
				"				<th>Edit</th>" + 
				"				<th>Delete</th>" + 
				"			</tr>" + 
				"		</thead>" + 
				"		<tbody>" ;
				
			String tbody="";
			List<Person> lstPerson = personDaos.getAll();
			for (Person person : lstPerson) {
				tbody+="<tr>" + 
						"				<td>"+person.getId()+"</td>" + 
						"				<td>"+person.getName()+"</td>" + 
						"				<td>"+person.getCountry()+"</td>" + 
						"				<td><a href=\"UpdatePerson?id="+person.getId()+"\">Edit</a></td>" + 
						"				<td><a href=\"DeletePerson?id="+person.getId()+"\">Delete</a></td>" + 
						"			</tr>"; ///////
			}
			String end = "	</tbody></table>" + 
					"</body>" + 
					"</html>";

			response.getWriter().println(html+tbody+end);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
