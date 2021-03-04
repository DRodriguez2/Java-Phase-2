package sql;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//insert credentials here
	private static final String URL = "jdbc:mysql://localhost:3306/e-commerce";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "*Ta408Q0u3o@~wb";
	
	protected static Connection con;
	protected static Statement stmnt;
	protected static PreparedStatement pStatement;
	protected static ResultSet results;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Index.jsp");
		
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pStatement = con.prepareStatement("select * from product where id=?");
			pStatement.setInt(1, id);
			results = pStatement.executeQuery();
			if (results.next()) {
				
				String queryResult = "id: " + results.getString(1) + " , description: " + results.getString(2);
				request.setAttribute("queryResult", queryResult);
				dis.forward(request, response);
				
			}else {
				request.setAttribute("queryResult", "No product found with ID: " + id);
				dis.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
