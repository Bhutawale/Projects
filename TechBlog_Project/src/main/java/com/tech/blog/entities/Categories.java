package com.tech.blog.entities;

public class Categories
{
	private int cid;
	private String cname;
	private String cdescription;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(int cid, String cname, String cdescription) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdescription = cdescription;
	}
	public Categories(String cname, String cdescription) {
		super();
		this.cname = cname;
		this.cdescription = cdescription;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	
	
	
}
