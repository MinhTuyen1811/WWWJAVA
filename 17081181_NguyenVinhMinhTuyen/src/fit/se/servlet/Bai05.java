package fit.se.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Bai04
 */
@WebServlet("/Bai05")
public class Bai05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.getWriter().println("Không hỗ trợ!");
			return;
		}
		// cấu hình tham số
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(REQUEST_SIZE);
		// thư mục lưu trữ hình ảnh, chạy ngoài Eclipse
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		// tạo thư mục nếu chưa tồn tại thư mục này
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			Iterator<FileItem> iter = formItems.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField() && item.getSize() > 0) {
					String fileName = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					item.write(storeFile); // lưu file vào thư mục
				}
			}
			response.getWriter().print("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<title>Result page</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>Upload has been done successfully!</h1>" + 
					"</body>" + 
					"</html>");
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
			response.getWriter().print("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<title>Result page</title>" + 
					"</head>" + 
					"<body>" + 
					"	<h1>There was an error: " + ex.getMessage()+"</h1>" + 
					"</body>" + 
					"</html>");
		}
	}

}
