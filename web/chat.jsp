<%-- 
    Document   : chat.jsp
    Created on : Apr 2, 2018, 11:18:54 PM
    Author     : himan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        To whom you want to send ..
        Write his eamil:
        <input name="email2" type="text" >
        
        <%@page import="java.sql.DriverManager"%>
        <%@page import="java.sql.ResultSet"%>
        <%@page import="java.sql.Statement"%>
        <%@page import="java.sql.Connection"%>
        <%@page import="java.sql.PreparedStatement"%>
        
        <% String  email1 = (String)session.getAttribute("email");
            String email2 = request.getParameter("email2");
            String message = request.getParameter("message");
            String email = request.getParameter("email");
            String driverNmae = "com.mysql.jdbc.Driver";
            String dbName = "sys";
            String userId = "root";
            String password = "1234";
            
            try{
                Class.forName(driverNmae);
                }
            catch(ClassNotFoundException e){
            e.printStackTrace();
            }
            
            Connection con  = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps1 = null;
            ResultSet rs1 = null;
            ResultSet rs2 = null;
            User e = new User();
            con = DriverManager.getConnection(dbName, userId, password);
            String sql1 = "select * from chat where email=? ";
            ps1.setString(1, e.getEmail1());
            ps1 = con.prepareStatement(sql1);
            rs1 = ps1.executeQuery();
            String sql2 = "select * from chat where email=?";
            ps2.setString(1, e.getEmail2());
            ps2 = con.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
        %>  
        
        
    </body>
</html>
