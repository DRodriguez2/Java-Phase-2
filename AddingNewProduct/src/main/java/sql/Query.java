package sql;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import hibernateobjects.HibernateUtil;
import hibernateobjects.Product;

@WebServlet(value = "/Query")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Index.jsp");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Product product;
		if((product = (Product)session.get(Product.class, id)) != null) {
			String queryResult = "id: " + product.getId() + " , description: " + product.getDescription();
			request.setAttribute("queryResult", queryResult);
			dis.forward(request, response);
		} else {
			request.setAttribute("queryResult", "No product found with ID: " + id);
			dis.forward(request, response);
		}
		session.close();

	}

}
