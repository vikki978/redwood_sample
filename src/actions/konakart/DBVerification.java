package actions.konakart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

class DBVerification{
    public void run(HashMap<String, Object> params)  throws ClassNotFoundException, SQLException{
        Connection conn;
        String dbURL = "jdbc:mysql://"+ params.get("host").toString() +":"+  params.get("port").toString();
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(dbURL,  params.get("user").toString(),  params.get("pass").toString());
	   Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery(params.get("sql").toString());
	      conn.close();
    }
}