package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao
{
	Connection con;

	public LikeDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean insertLike(int uid,int pid)

	{
		boolean f=false;
		try {
			
			String query="insert into likes (userid,postid) values (?,?)";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, uid);
			
			statement.setInt(2, pid);
			
			statement.executeUpdate();
			
			f=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public int countLikeonPost(int pid)
	{
		int count=0;
		
		try {
			String query="select count(*) from likes where postid=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, pid);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				count=resultSet.getInt("count(*)");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public boolean isLikedByUser(int uid,int pid)
	{
		boolean f=false;
		
		try 
		{
			String query="select * from likes where userid=? and postid=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, uid);
			
			statement.setInt(2, pid);
			
			ResultSet resultSet = statement.executeQuery();
		
			if(resultSet.next())
			{
				f=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteLike(int uid,int pid)
	{
		boolean f=false;
		
		try 
		{
			String query="delete from likes where userid=? and postid=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, uid);
			
			statement.setInt(2, pid);
			
			statement.executeUpdate();
			
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean hasUserLikedPost(int uid,int pid)
	{
		boolean hasLiked=false;
		
		try 
		{
			String query="select * from likes where userid=? and postid=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, uid);
			
			statement.setInt(2, pid);
			
			ResultSet set = statement.executeQuery();
			
			if(set.next())
				{
					hasLiked=true;
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return hasLiked;
	}
	
}
