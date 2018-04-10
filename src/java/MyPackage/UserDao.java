package MyPackage;

import java.io.InputStream;
import java.util.*;  
import java.sql.*;  
  
public class UserDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/sys","root","1234");    
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into usr(fname,lname,age,gender,contact,disease,location,email,password,photo) values (?,?,?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getFName());
            ps.setString(2,e.getLName());
            ps.setString(3,e.getAge());
            ps.setString(4,e.getGender());
            ps.setString(5,e.getContact());
            ps.setString(6,e.getDisease());
            ps.setString(7,e.getLocation());
            ps.setString(8,e.getEmail());
            ps.setString(9,e.getPassword());
           
            if(e.getImage()!=null){
            ps.setBlob(10, e.getImage());
            }  
            
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(SQLException ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int setMessages(User e){
        int status = 0;
        try {
        Connection con = UserDao.getConnection();
        String sql = "UPDATE chat SET message=? WHERE email=?";
        PreparedStatement ps = con.prepareCall(sql);
        ps.setString(1, e.getMessage());
        ps.setString(2, e.getEmail());
        
        }catch(SQLException ex ){
        ex.printStackTrace();
        }
        return status;
    }
    public static User getMessages(){
        User e = new User();
       
        try {
        Connection con = UserDao.getConnection();
        String sql = "select * from chat where email=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, e.getEmail());
        ResultSet rs= ps.executeQuery();
        if(rs.next()){  
                e.setMessage(rs.getString("message"));
              
            }  
        
        }catch(SQLException ex ){
        ex.printStackTrace();
        }
        return e;
    }
    
    
    public static User getUserByEmail(String email){  
        User e=new User();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from usr where email=?");  
            ps.setString(1,email);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setFName(rs.getString("fname"));  
                e.setLName(rs.getString("lname"));  
                e.setAge(rs.getString("age"));  
                e.setGender(rs.getString("gender"));  
                e.setContact(rs.getString("contact"));
                e.setDisease(rs.getString("disease"));
                e.setLocation(rs.getString("location"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setImage((InputStream) rs.getBlob("photo"));
              
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
      
}  