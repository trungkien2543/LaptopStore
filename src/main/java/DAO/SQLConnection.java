package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	Connection con;
	public SQLConnection() {
		try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=123456;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
	}
	public Connection getCon() {
		return con;
	}
}
