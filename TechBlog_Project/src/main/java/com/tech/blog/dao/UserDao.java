package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tech.blog.entities.User;

public class UserDao 
{
	public Connection con;
	
	public UserDao(Connection con)
	{
		this.con=con;
	}
	
	public boolean saveUser(User user)
	{
		boolean q=false;
		try
		{
			String query="insert into register (name,email,password,gender,about) values (?,?,?,?,?)";
			PreparedStatement statement =con.prepareStatement(query);
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getAbout());
			
			statement.execute();
			
			q=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return q;
	}
	
	public User getUserByEmailAndPassword(String email,String password)

	{
		User user=null;
		
		try
		{
			String query="select * from register where email=? and password=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet set = statement.executeQuery();
			if(set.next())
			{
				user =new User();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setRegdate(set.getTimestamp("regdate"));
				user.setProfile(set.getString("profile"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUser(User user)

	{
		boolean b=false;
		try
		{
				String query="update register set name=?,email=?,password=?,about=?,profile=? where id=?";
				
				PreparedStatement statement = con.prepareStatement(query);
				
				statement.setString(1, user.getName());
				statement.setString(2, user.getEmail());
				statement.setString(3, user.getPassword());
				statement.setString(4, user.getAbout());
				statement.setString(5, user.getProfile());
				statement.setInt(6, user.getId());
				
				statement.executeUpdate();
				b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	public User getUserByUserId(int uid)
	{
		User user=null;
	
		try 
		{
			String query="select * from register where id=?";
		
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1,uid);
			
			ResultSet set = statement.executeQuery();
			
			while(set.next())
			{
				user=new User();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
