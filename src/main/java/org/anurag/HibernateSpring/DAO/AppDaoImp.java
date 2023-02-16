package org.anurag.HibernateSpring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.anurag.HibernateSpring.model.User;

public class AppDaoImp implements AppDao {

	private DataSource dataSource;
	
	
	public AppDaoImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public List<User> listUsers() {
		 String SQL = "select * from user";
		 List<User> listUser = new ArrayList<User>();;
		 Connection conn = null;
		 
		 try {
			 conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(SQL);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 User temp = new User(
						 rs.getInt("user_id"),
						 rs.getString("name"),
						 rs.getString("email")
						 );
				 
				 listUser.add(temp);
			 }
			 rs.close();
			 ps.close();
			 return listUser;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			 if(conn!=null) {
				 try {
					 conn.close();
				 }catch(SQLException e) {e.printStackTrace();}
			 }
		 }
		
	}

}
