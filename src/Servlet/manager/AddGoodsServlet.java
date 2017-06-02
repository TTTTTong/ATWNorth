package Servlet.manager;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import Bean.GoodsInfo;
import Util.DBUtils;
import db.GetNextGoodsId;

public class AddGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param pageContext 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GoodsInfo good = new GoodsInfo();
		good.setSales(0);
		good.setGoodsid(new GetNextGoodsId().GetNextGoodsId());
		good.setImage("../img/"+new GetNextGoodsId().GetNextGoodsId()+".jpg");
		
		FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
        	//设置实例属性
			List<FileItem> items = upload.parseRequest(request);
			String[] str = new String[3];
			int i = 0;
			for (Object object : items){
				FileItem fileItem = (FileItem) object;
				
				 if (fileItem.isFormField()) {
					 	str[i] = fileItem.getString();
					 	i++;
	                }
			}
		good.setGoodsname(str[0]);
		good.setPrice(Integer.parseInt(str[1]));
		good.setDscb(str[2]);
		for (Object object : items){
			FileItem fileItem = (FileItem) object;
			 if (fileItem.isFormField()) {
                }else {
                	String path="D:\\EclipseWorkSpace\\ATWNorth\\WebContent\\ui 2.0\\img\\";
                	String pname = path+good.getGoodsid()+".jpg";
             	    File file = new File(pname);

                	 try {
						fileItem.write(file);
					} catch (Exception e) { 
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("写入图片失败");
					}
				}
		}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        Connection conn = DBUtils.getConnection();
        String sql = "insert into goods values(?,?,?,?,?,?)";
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, good.getGoodsid());
			stmt.setString(2, good.getGoodsname());
			stmt.setInt(3, good.getSales());
			stmt.setInt(4, good.getPrice());
			stmt.setString(5, good.getDscb());
			stmt.setString(6, good.getImage());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
		System.out.println("add  "+good.getGoodsname());
		response.getWriter().print("<script>alert(\"Successful operation!\");</script>");
		response.sendRedirect("/ATWNorth/ui 2.0/customer/cus_main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
