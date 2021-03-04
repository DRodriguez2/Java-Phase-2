package sql;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import hibernateobjects.HibernateUtil;
import hibernateobjects.Product;


@WebServlet(value = "/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Index.jsp");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Product p1 = new Product(Integer.parseInt(request.getParameter("id")), request.getParameter("description"), request.getParameter("name"), request.getParameter("price"));
		session.save(p1);		
		try {
			session.getTransaction().commit();
			request.setAttribute("queryResult", "Successfully added to database");
		}catch (RollbackException e) {
			request.setAttribute("queryResult", "Unable to add to database");	
		}
		
		session.close();
		dis.forward(request, response); 
	}

}
