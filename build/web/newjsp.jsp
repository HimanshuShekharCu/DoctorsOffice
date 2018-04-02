<%

        
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
        
        ResultSet resultSet = null;
        %>

        <%
        try{ 
        connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
        String sql ="SELECT * FROM usr where email=?";
        PreparedStatement ps =connection.prepareStatement(sql);
        session=request.getSession(false);  
        String email=(String)session.getAttribute("uname");  
        
        ps.setString(1,email);


        resultSet = ps.executeQuery(sql);
        while(resultSet.next()){
            out.print(resultSet.getString("fname"));
            out.print(resultSet.getString("lname"));
            
        }} catch (Exception e) {
        e.printStackTrace();
        }
   
        %>

        <% 
        

        
        %>
