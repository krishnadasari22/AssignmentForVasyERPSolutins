package com.cruddata;
import java.util.*;  
import java.sql.*;  
  
public class CustomerDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Customer e){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into database.customer_details(customer_name,customer_mobile,customer_email,customer_address,customer_state,customer_pincode) values (?,?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getMobile());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getAddress());
            ps.setString(5,e.getState());
            ps.setString(6,e.getPincode());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Customer e){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Customer set customer_name=?,customer_mobile=?,customer_email=?,customer_address=?,customer_state=?,customer_pincode=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getMobile());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getAddress());
            ps.setString(5,e.getState());
            ps.setString(6,e.getPincode());
            ps.setInt(7,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from database.customer_details where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Customer getCustomerById(int id){  
    	Customer e=new Customer();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from database.customer_details where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setMobile(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setAddress(rs.getString(5));
                e.setState(rs.getString(6));
                e.SetPincode(rs.getString(7));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Customer> getAllCustomers(){  
        List<Customer> list=new ArrayList<Customer>();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from database.customer_details");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Customer e=new Customer();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setMobile(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setAddress(rs.getString(5));
                e.setState(rs.getString(6));
                e.SetPincode(rs.getString(7));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
	}  
}