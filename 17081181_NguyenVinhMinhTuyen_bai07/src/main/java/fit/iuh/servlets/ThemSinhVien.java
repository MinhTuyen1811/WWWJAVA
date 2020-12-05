package fit.iuh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.daos.SinhVienDAO;
import fit.iuh.entities.SinhVien;

/**
 * Servlet implementation class ThemSinhVien
 */
@WebServlet("/ThemSinhVien")
public class ThemSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienDAO svDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSinhVien() {
        super();
        // TODO Auto-generated constructor stub
        svDAO= new SinhVienDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		PrintWriter out= response.getWriter();
		String html="<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" + 
				"<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">" + 
				"<title>Thêm mới sinh viên - Quản lý sinh viên</title>" + 
				"<script src=\"./js/jquery-3.4.1.min.js\"></script>" + 
				"<script src=\"./js/bootstrap.min.js\"></script>" + 
				"<style>" + 
				"input[type=text], textarea {" + 
				"	width: 100%;" + 
				"	padding: 12px;" + 
				"	border: 1px solid #ccc;" + 
				"	border-radius: 4px;" + 
				"	resize: vertical;" + 
				"}" + 
				"label {" + 
				"  padding: 12px 12px 12px 0;" + 
				"  display: inline-block;" + 
				"}" + 
				"input[type=radio] {" + 
				"	margin:12px;" + 
				"	resize: vertical;" + 
				"}" + 
				"" + 
				".col-25 {" + 
				"	float: left;" + 
				"	width: 25%;" + 
				"	margin-top: 6px;" + 
				"	margin-left: 10px;" + 
				"}" + 
				"" + 
				".col-75 {" + 
				"	float: left;" + 
				"	width: 70%;" + 
				"	margin-top: 6px;" + 
				"}" + 
				"" + 
				"/* Clear floats after the columns */" + 
				".row:after {" + 
				"	content: \"\";" + 
				"	display: table;" + 
				"	clear: both;" + 
				"}" + 
				"</style>" + 
				"</head>" + 
				"<body>" + 
				"	<!-- Navigation -->" + 
				"	<nav class=\"navbar navbar-light bg-light\">" + 
				"		<div class=\"container-fluid\">" + 
				"			<a class=\"navbar-brand\" href=\"\\\"><img alt=\"logo\"" + 
				"				src=\"images/logo.png\" style=\"width: 150px;\"></a>" + 
				"			<h3>CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN SINH VIÊN</h3>" + 
				"			<h3></h3>" + 
				"		</div>" + 
				"	</nav>" + 
				"	<section>" + 
				"		<div class=\"container-fluid\">" + 
				"			<div class=\"row\">" + 
				"				<div class=\"col-xl-2\">" + 
				"					<ul class=\"nav flex-column\">" + 
				"						<li class=\"nav-item my-2\"><a class=\"nav-link btn border\"" + 
				"							href=\"\">Thêm mới sinh viên</a></li>" + 
				"						<li class=\"nav-item\"><a class=\"nav-link btn btn-primary\"" + 
				"							href=\"./\">Danh sách sinh viên</a></li>" + 
				"					</ul>" + 
				"				</div>" + 
				"				<div class=\"col-xl-9 ml-3 border-left\">" + 
				"					<form action=\"\" method=\"post\">" + 
				"						<div class=\"row\">" + 
				"							<div class=\"col-25\">" + 
				"								<label>Mã sinh viên:</label>" + 
				"							</div>" + 
				"							<div class=\"col-75\">" + 
				"								<input type=\"text\" name=\"MaSV\">" + 
				"							</div>" + 
				"						</div>" + 
				"						<div class=\"row\">" + 
				"							<div class=\"col-25\">" + 
				"								<label>Họ tên:</label>" + 
				"							</div>" + 
				"							<div class=\"col-75\">" + 
				"								<input type=\"text\" name=\"HoTen\">" + 
				"							</div>" + 
				"						</div>" + 
				"						<div class=\"row\">" + 
				"							<div class=\"col-25\">" + 
				"								<label>Giới tính:</label>" + 
				"							</div>" + 
				"							<div class=\"col-75\">" + 
				"								<input type=\"radio\" name=\"GioiTinh\" value=\"Nam\">Nam <input" + 
				"									type=\"radio\" name=\"GioiTinh\" value=\"Nữ\">Nữ" + 
				"							</div>" + 
				"						</div>" + 
				"						<div class=\"row\">" + 
				"							<div class=\"col-25\">" + 
				"								<label>Số điện thoại:</label>" + 
				"							</div>" + 
				"							<div class=\"col-75\">" + 
				"								<input type=\"text\" name=\"SoDT\">" + 
				"							</div>" + 
				"						</div>" + 
				"						<div class=\"row\">" + 
				"							<div class=\"col-25\">" + 
				"								<label>Địa chỉ:</label>" + 
				"							</div>" + 
				"							<div class=\"col-75\">" + 
				"								<textarea id=\"subject\" name=\"DiaChi\"" + 
				"									placeholder=\"Write something..\" style=\"height: 100px\"></textarea>" + 
				"							</div>" + 
				"						</div>" + 
				"						<div class=\"row mb-2\">" + 
				"							<div class=\"col-25\"></div>" + 
				"							<div class=\"col-75\">" + 
				"								<input type=\"submit\" class=\"btn btn-success\" value=\"Lưu\">" + 
				"							</div>" + 
				"						</div>" + 
				"					</form>" + 
				"				</div>" + 
				"			</div>" + 
				"		</div>" + 
				"	</section>" + 
				"	<footer class=\"jumbotron text-center\">" + 
				"  		<p>Nguyễn Vĩnh Minh Tuyền _17081181</p>" + 
				"	</footer>" + 
				"</body>" + 
				"</html>";
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String maSV= request.getParameter("MaSV");
		String hoTen= request.getParameter("HoTen");
		String gioiTinh= request.getParameter("GioiTinh");
		String soDT= request.getParameter("SoDT");
		String diaChi= request.getParameter("DiaChi");
		
		SinhVien sv= new SinhVien(Long.valueOf(maSV), hoTen, gioiTinh, soDT, diaChi);
		
		boolean result= svDAO.addSinhVien(sv);
		if(result) {
			String html="<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" + 
					"<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">" + 
					"<title>Quản lý sinh viên</title>" + 
					"<script src=\"./js/jquery-3.4.1.min.js\"></script>" + 
					"<script src=\"./js/bootstrap.min.js\"></script>" + 
					"</head>" + 
					"<body>" + 
					"	<!-- Navigation -->" + 
					"	<nav class=\"navbar navbar-light bg-light\">" + 
					"		<div class=\"container-fluid\">" + 
					"			<a class=\"navbar-brand\" href=\"\\\"><img alt=\"logo\"" + 
					"				src=\"images/logo.png\" style=\"width: 150px;\"></a>" + 
					"			<h3>CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN SINH VIÊN</h3>" + 
					"			<h3></h3>" + 
					"		</div>" + 
					"	</nav>" + 
					"	<section class=\"page-section portfolio\" id=\"portfolio\">" + 
					"		<div class=\"container-fluid\">" + 
					"			<div class=\"row my-2\">" + 
					"				<div class=\"col-xl-2\">" + 
					"					<ul class=\"nav flex-column\">" + 
					"						<li class=\"nav-item mb-2\"><a class=\"nav-link btn btn-success\"" + 
					"							href=\"\">Thêm mới sinh viên</a></li>" + 
					"						<li class=\"nav-item\"><a class=\"nav-link btn btn-primary\"" + 
					"							href=\"./\">Danh sách sinh viên</a></li>" + 
					"					</ul>" + 
					"				</div>" + 
					"				<div class=\"col-xl-10\">" + 
					"					<h3>Thêm thành công</h3>";
			String end="				</div>" + 
					"			</div>" + 
					"		</div>" + 
					"	</section>" + 
					"<footer class=\"jumbotron text-center\">\r\n" + 
					"  		<p>Nguyễn Vĩnh Minh Tuyền _17081181</p>\r\n" + 
					"</footer>"+
					"</body>" + 
					"</html>";
			response.getWriter().println(html+end);
		}
		else {
			String html="<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" + 
					"<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">" + 
					"<title>Quản lý sinh viên</title>" + 
					"<script src=\"./js/jquery-3.4.1.min.js\"></script>" + 
					"<script src=\"./js/bootstrap.min.js\"></script>" + 
					"</head>" + 
					"<body>" + 
					"	<!-- Navigation -->" + 
					"	<nav class=\"navbar navbar-light bg-light\">" + 
					"		<div class=\"container-fluid\">" + 
					"			<a class=\"navbar-brand\" href=\"\\\"><img alt=\"logo\"" + 
					"				src=\"images/logo.png\" style=\"width: 150px;\"></a>" + 
					"			<h3>CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN SINH VIÊN</h3>" + 
					"			<h3></h3>" + 
					"		</div>" + 
					"	</nav>" + 
					"	<section class=\"page-section portfolio\" id=\"portfolio\">" + 
					"		<div class=\"container-fluid\">" + 
					"			<div class=\"row my-2\">" + 
					"				<div class=\"col-xl-2\">" + 
					"					<ul class=\"nav flex-column\">" + 
					"						<li class=\"nav-item mb-2\"><a class=\"nav-link btn btn-success\"" + 
					"							href=\"\">Thêm mới sinh viên</a></li>" + 
					"						<li class=\"nav-item\"><a class=\"nav-link btn btn-primary\"" + 
					"							href=\"./\">Danh sách sinh viên</a></li>" + 
					"					</ul>" + 
					"				</div>" + 
					"				<div class=\"col-xl-10\">" + 
					"					<h3>Thêm thất bại</h3>";
			String end="				</div>" + 
					"			</div>" + 
					"		</div>" + 
					"	</section>" + 
					"<footer class=\"jumbotron text-center\">\r\n" + 
					"  		<p>Nguyễn Vĩnh Minh Tuyền _17081181 - 17074451</p>\r\n" + 
					"</footer>"+
					"</body>" + 
					"</html>";
			response.getWriter().println(html+end);
		}
		
	}

}
