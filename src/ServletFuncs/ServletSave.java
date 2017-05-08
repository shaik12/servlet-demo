
package ServletFuncs;
import java.io.IOException;
import java.io.PrintWriter;
import com.mypack.EmployeeData;
import com.mypack.DAOServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletSave")
public class ServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        
		PrintWriter out=response.getWriter();
		DAOServlet sdao=new DAOServlet();
        EmployeeData emp=new EmployeeData();
        emp.setName(request.getParameter("name"));
        emp.setPassword(request.getParameter("password"));
        emp.setEmail(request.getParameter("email"));
        emp.setCountry(request.getParameter("country"));
        int i=sdao.insertEmployeeData(emp);
        if(i>0)
		{
			request.getRequestDispatcher("Newindex.html").include(request, response);
			out.print("<p>Record saved successfully!</p>");           
		}

	}

}
