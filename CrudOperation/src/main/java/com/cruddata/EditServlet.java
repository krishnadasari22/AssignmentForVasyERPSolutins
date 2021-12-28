package com.cruddata;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Customer</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Customer e=CustomerDao.getCustomerById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Customer_Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Customer_Mobile:</td><td><input type='mobile' name='mobile' value='"+e.getMobile()+"'/>"
        + "</td></tr>"); 
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>"); 
        out.print("<tr><td>Customer_Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
        out.print("<tr><td>Customer_State:</td><td><input type='text' name='state' value='"+e.getState()+"'/></td></tr>");
        out.print("<tr><td>Customer_Pincode:</td><td><input type='text' name='pincode' value='"+e.getPincode()+"'/></td></tr>");

        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}