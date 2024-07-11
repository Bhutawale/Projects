package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Categories;
import com.tech.blog.entities.Posts;

public class PostDao {
	Connection con;

	public PostDao(Connection con) {
		super();
		this.con = con;
	}

	public ArrayList<Categories> getAllCategories() {
		ArrayList<Categories> list = new ArrayList<Categories>();

		try {
			String query = "select * from categories";

			Statement statement = con.createStatement();

			ResultSet set = statement.executeQuery(query);

			while (set.next()) {
				int cid = set.getInt(1);
				String cname = set.getString(2);
				String cdescription = set.getString(3);

				Categories c = new Categories(cid, cname, cdescription);

				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public boolean savePost(Posts post)
	{
		boolean f=false;
		
		try {	
			
			String query="insert into posts (ptitle,pcontent,pcode,ppic,catid,uid) values (?,?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setString(1, post.getPtitle());
			statement.setString(2, post.getPcontent());
			statement.setString(3, post.getPcode());
			statement.setString(4, post.getPpic());
			statement.setInt(5, post.getCatid());
			statement.setInt(6, post.getUid());
			
			statement.execute();
			
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return f;
	}

	public List<Posts> getAllPosts()
	{
		List<Posts> plist=new ArrayList<Posts>();
		
		try 
		{
			String query="select * from Posts order by pid desc";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			
			ResultSet set = statement.executeQuery();
			
			
			
			while(set.next())
			{
				int pid = set.getInt("pid");
				String ptitle = set.getString("ptitle");
				String pcontent = set.getString("pcontent");
				String pcode = set.getString("pcode");
				String ppic = set.getString("ppic");
				Timestamp pdate = set.getTimestamp("pdate");
				int catid = set.getInt("catid");
				int uid = set.getInt("uid");
				
				Posts p=new Posts(pid, ptitle, pcontent, pcode, ppic, pdate, catid, uid);
				
				plist.add(p);	
			
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return plist;
	}
	
	
	public List<Posts> getPostByCatId(int cid)
	{
		List<Posts> listById=new ArrayList<Posts>();
		
		try {
			
			String query="select * from posts where catid=? order by pid desc";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, cid);
			
			ResultSet set= statement.executeQuery();
			
			while(set.next())
			{
				int pid = set.getInt("pid");
				String ptitle = set.getString("ptitle");
				String pcontent = set.getString("pcontent");
				String pcode = set.getString("pcode");
				String ppic = set.getString("ppic");
				Timestamp pdate = set.getTimestamp("pdate");
			
				int uid = set.getInt("uid");
				
				Posts p=new Posts(pid, ptitle, pcontent, pcode, ppic, pdate, cid, uid);
				
				listById.add(p);		
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listById;
	}
	
	public List<Posts> getPostByPid(int Pid)
	{
		List<Posts> post=new ArrayList<Posts>();
		
		try {
			
			String query="select * from posts where pid=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, Pid);
			
			ResultSet set = statement.executeQuery();
			
			while(set.next())
			{
				int pid = set.getInt("pid");
				String ptitle = set.getString("ptitle");
				String pcontent = set.getString("pcontent");
				String pcode = set.getString("pcode");
				String ppic = set.getString("ppic");
				int uid = set.getInt("uid");
				Timestamp pdate= set.getTimestamp("pdate");
				
				Posts p1=new Posts(Pid, ptitle, pcontent, pcode, ppic, pdate, pid, uid);
				
				post.add(p1);
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return post;
	}
}
