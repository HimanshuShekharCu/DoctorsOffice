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
                         "insert into usr(fname,lname,age,gender,contact,disease,location,email,password) values (?,?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getFName());
            ps.setString(2,e.getLName());
            ps.setString(3,e.getAge());
            ps.setString(4,e.getGender());
            ps.setString(5,e.getContact());
            ps.setString(6,e.getDisease());
            ps.setString(7,e.getLocation());
            ps.setString(8,e.getEmail());
            ps.setString(9,e.getPassword());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user905 set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
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
              
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  