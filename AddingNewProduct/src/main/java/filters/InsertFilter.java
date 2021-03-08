package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/insert" })
public class InsertFilter implements Filter {
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		try {
			Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Invalid ID </SPAN>");
			return;
		}
		String description = request.getParameter("description");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		if(description.isEmpty() || name.isEmpty() || price.isEmpty()) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Description, name, or price cannot be left empty</SPAN>");
			return;
		}
		else if(description.length() > 255)  {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Description exceeds maximum length of 255 characters </SPAN>");
			return;
		} else if(name.length() > 255)  {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Name exceeds maximum length of 255 characters </SPAN>");
			return;
		} else if(price.length() > 255)  {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Price exceeds maximum length of 255 characters </SPAN>");
			return;
		} 
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
