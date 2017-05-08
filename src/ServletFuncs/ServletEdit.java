package ServletFuncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypack.DAOServlet;
import com.mypack.EmployeeData;
import java.io.PrintWriter;


@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletEdit() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DAOServlet sdao = new DAOServlet();
		EmployeeData e= sdao.getEmployeeById(Integer.parseInt(request.getParameter("id")));
		out.print("<form action='ServletEdit2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td> <input type='hidden' name='id' value='"+e.getId()+"'  /></td></tr>");
        out.print("<tr><td> Name :</td><td><input type='text' name='name' value='"+e.getName()+"' /></td></tr>");
        out.print("<tr><td>Password :</td><td><input type='password' name='password' value='"+e.getPassword()+"'  /></td></tr>");
        out.print("<tr><td>Email :</td><td><input type='email' name='email' value='"+e.getEmail()+"'  /></td></tr>");
        out.print("<tr><td>Country :</td><td>");
        out.print("<select name='country' style='width:150px'>");
        out.print("<option>India</option>");
        out.print("<option>USA</option>");
        out.print("<option>UK</option>");
        out.print("<option>Other</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan=2><input type='submit' value='Edit & Save'  /></td></tr>");
        out.print("</table>");
        out.print("</form>");
      }
	}
