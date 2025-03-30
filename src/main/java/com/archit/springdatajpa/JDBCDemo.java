package com.archit.springdatajpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        //7 important steps for using a database:
        //1. Import packages
        //2. Load the driver
        //3. Register the driver
        //4. Create connection
        //5. Create statement
        //6. Execute statement
        //7. Close connection

        Connection con= DriverManager.getConnection("jdbc:h2:~/test","sa","");

        String query1="insert into student values(5,'Archit',70)";
        //Above query is hard coded. To get input from user to create a query we need to write something like below
        int rollNumber=5;
        String name="Archit";
        int marks=91;
        String query2="insert into student values("+rollNumber+",'"+name+"',"+marks+")";
        //Above format can get complicated, hence we have PreparedStatement
        String query3="insert into student values(?,?,?)";
        PreparedStatement st =con.prepareStatement(query3);
        st.setInt(1,rollNumber);
        st.setString(2,name);
        st.setInt(3,marks);
        //Above format helps writing a query using user inputs efficiently and can run like below
        st.execute();

        System.out.println("Connection established");
        con.close();
    }
}
