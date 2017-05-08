package ServletFuncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.mypack.EmployeeData;
import com.mypack.DAOServlet;
import java.io.PrintWriter;

@WebServlet("/ServletView")
public class ServletView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public ServletView() {
        super();
        
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 response.setContentType("text/html");
	 PrintWriter out=response.getWriter();
	 DAOServlet sdao = new DAOServlet();
	 ArrayList<EmployeeData> arrCol = sdao.getAllEmployees();
	 String str="";
	 str+="<table border=1><tr><th>Emp ID</th><th>Emp Name</th><th>Password</th><th>Email</th><th>Country</th></tr>";
	 for(EmployeeData e:arrCol){
		 str+="<tr><td>"+e.getId()
		 	+"</td><td>"+e.getName() 
			+"</td><td>"+e.getPassword()
			+ "</td></td>"+e.getEmail()
			+"</td><td>"+e.getCountry()
		    +"</td><td> <a href='ServletEdit?id="+e.getId()+"'>Edit</a></td><td><a href='ServletDelete?id="+e.getId()+"'>Delete</a></td></tr>";
		 }
	 str+="</table>";
	 out.println(str);
	 }

	

}
