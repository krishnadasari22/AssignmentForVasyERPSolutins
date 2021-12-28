package com.cruddata;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Customer</a>");  
        out.println("<h1>Customers List</h1>");  
          
        List<Customer> list=CustomerDao.getAllCustomers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Customer_Id</th><th>Customer_Name</th><th>Customer_Mobile</th><th>Customer_Email</th><th>Customer_Address</th>"
        		+ "<th>Customer_State</th><th>Customer_Pincode</th><th>Edit</th><th>Delete</th></tr>");  
        for(Customer e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getMobile()+"</td>"
         		+ "<td>"+e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getState()+"</td><td>"+e.getPincode()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
