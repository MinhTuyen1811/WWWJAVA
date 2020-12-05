package fit.iuh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.iuh.daos.SinhVienDAO;
import fit.iuh.entities.SinhVien;

/**
 * Servlet implementation class QuanLySinhVien
 */
@WebServlet("/trangchu")
public class QuanLySinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SinhVienDAO svDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySinhVien() {
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
				"						<li class=\"nav-item mb-2\"><a class=\"nav-link btn border\"" + 
				"							href=\"ThemSinhVien\">Thêm mới sinh viên</a></li>" + 
				"						<li class=\"nav-item\"><a class=\"nav-link btn btn border\"" + 
				"							href=\"\">Danh sách sinh viên</a></li>" + 
				"					</ul>" + 
				"				</div>" + 
				"				<div class=\"col-xl-10\">" + 
				"					<table id=\"dtSinhVien\" class=\"table table-striped table-bordered table-responsive\"" + 
				"						style=\"width: 100%\">" + 
				"						<thead>" + 
				"							<tr>" + 
				"								<th>Mã SV</th>" + 
				"								<th>Họ tên</th>" + 
				"								<th>Giới tính</th>" + 
				"								<th>Số điện thoại</th>" + 
				"								<th>Địa chỉ</th>" + 
				"							</tr>" + 
				"						</thead>";
		String tbody="";
		List<SinhVien> lstSinhVien= svDAO.getAll();
		for (SinhVien sinhVien : lstSinhVien) {
			tbody+="			<tr>" + 
					"				<td>"+sinhVien.getMaSV()+"</td>" + 
					"				<td>"+sinhVien.getHoTen()+"</td>" + 
					"				<td>"+sinhVien.getGioiTinh()+"</td>" + 
					"				<td>"+sinhVien.getSoDienThoai()+"</td>" +  
					"				<td>"+sinhVien.getDiaChi()+"</td>" +  
					"			</tr>";
		}
		String end= "						</tbody>" + 
				"					</table>" + 
				"				</div>" + 
				"			</div>" + 
				"		</div>" + 
				"	</section>" + 
				"<footer class=\"jumbotron text-center\">\r\n" + 
				"  		<p>Nguyễn Vĩnh Minh Tuyền _17081181</p>\r\n" + 
				"</footer>"+
				"</body>" + 
				"</html>";
		out.println(html+tbody+end);
	}

}
