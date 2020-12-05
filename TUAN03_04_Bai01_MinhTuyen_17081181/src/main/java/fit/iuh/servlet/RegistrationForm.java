package fit.iuh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.entities.Student;


@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter dt = response.getWriter();
		String fname = request.getParameter("txtFName");
		String lname = request.getParameter("txtLName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("txtEmail");
		String mobileNum = request.getParameter("txtMobileNumber");
		String gender = request.getParameter("Gender");
		String address = request.getParameter("taAddress");
		String city = request.getParameter("txtCity");
		String pinCode = request.getParameter("txtPinCode");
		String state = request.getParameter("txtState");
		String country = request.getParameter("txtCountry");
		String hobbies = request.getParameter("ckHobbies");
		String course = request.getParameter("txtrCourse");
		String birthdate = day + " "+ month + " "+ year;
		Student sv = new Student();
		sv.setFname(fname);
		sv.setLname(lname);
		sv.setDay(day);
		sv.setMonth(month);
		sv.setYear(year);
		sv.setEmail(email);
		sv.setMobileNum(mobileNum);
		sv.setGender(gender);
		sv.setAddress(address);
		sv.setCity(city);
		sv.setPinCode(pinCode);
		sv.setState(state);
		sv.setCountry(country);
		sv.setHobbies(hobbies);
		sv.setCourse(course);
		request.setAttribute("student", sv);
		RequestDispatcher rd = request.getRequestDispatcher("Form.jsp");
		rd.forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
		}
	
}
