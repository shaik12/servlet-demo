package ServletFuncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.mypack.DAOServlet;
import com.mypack.EmployeeData;


@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DAOServlet sdao = new DAOServlet();
		int i = sdao.DeleteEmployeeData(Integer.parseInt(request.getParameter("id")));
		if(i>0)
		{		
			out.print("<p>Record Deleted successfully!</p>");		
		}
		
		ArrayList<EmployeeData> arrCol=sdao.getAllEmployees();
		String str="";
	    str+="<table border=1><tr><th>Emp ID</th><th>Emp Name</th><th>Password</th><th>Email</th><th>Country</th></tr>";
	    for(EmployeeData e:arrCol)
	    {
	    	str+="<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>";
	    }
	    str+="</table>";
	    out.println(str);
	    out.println("<a href='Newindex.html'>Home Page</a>");
		}
		
	}

	


