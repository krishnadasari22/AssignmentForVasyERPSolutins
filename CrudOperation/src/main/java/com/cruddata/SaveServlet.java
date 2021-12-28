package com.cruddata;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String mobile=request.getParameter("mobile");  
        String email=request.getParameter("email");  
        String address=request.getParameter("address");  
        String state=request.getParameter("state");
        String pincode=request.getParameter("pincode");
          
        Customer e=new Customer();  
        e.setName(name);  
        e.setMobile(mobile);  
        e.setEmail(email);  
        e.setAddress(address);
        e.setState(state); 
        e.SetPincode(pincode); 
          
        int status=CustomerDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}