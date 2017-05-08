package ServletFuncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.mypack.DAOServlet;
import com.mypack.EmployeeData;

@WebServlet("/ServletEdit2")
public class ServletEdit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		DAOServlet sdao = new DAOServlet();
		EmployeeData emp = new EmployeeData();
		emp.setId(Integer.parseInt(request.getParameter("id")));
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setEmail(request.getParameter("email"));
		emp.setCountry(request.getParameter("country"));
		int i=sdao.UpdateEmployeeData(emp);
		if(i>0)
		{
			request.getRequestDispatcher("Newindex.html").include(request, response);
			pw.println("successfully updated");
		}
		else
		{
			pw.println("Invalid Update");
			
		}
		
		
		
		
		

	}

}
