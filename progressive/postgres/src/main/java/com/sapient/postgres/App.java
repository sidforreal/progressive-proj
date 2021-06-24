package com.sapient.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.beans.User;
import com.sapient.utils.GetConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection conn = GetConnection.getPostGressConn();
        System.out.println(conn);
		
		List<User> list = null;
		try {
			String sql1 = "SELECT * FROM users";
			GetConnection gc = new GetConnection();
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql1);
			list = new ArrayList<User>();
			
			gc.rs = gc.ps.executeQuery(); 
			while(gc.rs.next()) {
				User emp = new User(); 
				emp.setUserId(gc.rs.getInt(1));
				emp.setUserName(gc.rs.getString(2));
				list.add(emp); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(User u:list) System.out.println(u);
		
    }
}
