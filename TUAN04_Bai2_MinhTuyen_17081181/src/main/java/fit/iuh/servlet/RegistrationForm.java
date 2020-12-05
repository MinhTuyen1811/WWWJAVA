package fit.iuh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.dao.PersonDAO;
import fit.iuh.entities.Person;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	static final long serialVersionUID = 1L;

	// b1 khai bao dao
	PersonDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
		// new instance dao
		dao = new PersonDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// khi truy cap vo servlet chuyen den trang jsp dang ky
		response.sendRedirect(request.getContextPath() + "/form.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String firstName = request.getParameter("FistName");
		String lastName = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String birthday = request.getParameter("Day")+"/"+request.getParameter("Month")+"/"+request.getParameter("Year");
		Person person= new Person(firstName, lastName, email, password, birthday);
		dao.insert(person);
		
		List<Person> lst= dao.getAll();
		request.setAttribute("lst", lst);
		getServletContext().getRequestDispatcher("/managementPerson.jsp").forward(request, response);
	}
}
