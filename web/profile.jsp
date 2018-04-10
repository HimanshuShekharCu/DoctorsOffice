<%-- 
    Document   : profile.jsp
    Created on : Apr 1, 2018, 12:24:15 PM
    Author     : himan
--%>
    <%@ page import="MyPackage.User" %>
    <%@ page import="MyPackage.UserDao" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Navbar Template for Bootstrap</title>
    
    <!-- Bootstrap core CSS -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="css/agency.min.css" rel="stylesheet">
   <style>
       
   </style>
    </head>
    <body>
       <%
            String email = (String)session.getAttribute("email") ;
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3308/";
            String dbName = "sys";
            String userId = "root";
            String password = "1234";

            try {
            Class.forName(driverName);
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }

            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
        %>

        <%
        try{ 
            User e = new User() ;
        connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
        String sql ="SELECT * FROM record where email=?";
        ps=connection.prepareStatement(sql);
        ps.setString(1, email);
        resultSet = ps.executeQuery(sql);
        while(resultSet.next()){
        e.setImage(resultSet.getBinaryStream("photo"));
        e.setFName(resultSet.getString("fname"));
        }
        out.print(e.getFName());

} catch (Exception e) {
e.printStackTrace();
}
%>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                    <a class="navbar-brand" href="index.html">Home</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item ">
                            <a class="nav-link" href="how_it_works.html">How it Works <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="what_we_treat.html">What We Treat</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link " href="why_us.html">Why Us </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link " href="contact.html">Contact us </a>
                        </li> 
                    </ul>
                <form class="form-inline mt-2 mt-md-0">
                  <input class="form-control mr-sm-2" type="text" placeholder="Search Doctor by Name" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
              </div>
            </nav>
        

         <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
            <div class="row">
                <div class="col-md-8">
                    <div class="container">
                        <h1 class="display-3"><%=session.getAttribute("fname")%><%=session.getAttribute("lname")%></h1>
                        <p><%=session.getAttribute("location")%></p>
                    </div>  
                </div>
                <div class="col-md-4">
                          <div class="pro_pic">
                              <img src="<%=session.getAttribute("photo")%>" width="150" height="150"/>
                          </div>
                </div>
            </div>
      </div>      
      

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>Personal Details</h2>
            <ul>
                <li><b>Age <%=session.getAttribute("age")%></b></li>
                <li><b>Gender <%=session.getAttribute("gender")%></b></li>
            </ul>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>Meidcal Details</h2>
            <ul>
                <li><b>Old Diseases <%=session.getAttribute("disease")%></b></li>
                <li><b>Allergy  NO</b></li>
            </ul>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>Contact Details</h2>
            <ul>
                <li><b>Contact <%=session.getAttribute("contact")%></b></li>
                <li><b>Email <%=session.getAttribute("email")%></b></li>
            </ul>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>
    </body>
</html>
