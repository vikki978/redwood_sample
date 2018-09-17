package actions.konakart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

import java.util.*;

class DBVerification{
    public void run(HashMap<String, String> params)  throws ClassNotFoundException, SQLException{
        Connection conn;
        Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + params.get("host") + ":" + params.get("port") + "/" + params.get("dbName") + "?autoReconnect=true&useSSL=false";
	    conn = DriverManager.getConnection(connectionURL,  params.get("user"),  params.get("pass"));
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(params.get("sql"));
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        String actualValue = "";
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
               if(rs.getString(i).equalsIgnoreCase(params.get("uiValue")))
                {
                   actualValue = rs.getString(i);
                   break;
                }
			}
        }
        System.out.println("DB Data Value: "+actualValue);
        assertEquals(params.get("uiValue"),actualValue);
		rs.close();
		conn.close();
    }
}