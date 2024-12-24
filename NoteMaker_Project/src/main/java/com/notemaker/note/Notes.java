package com.notemaker.note;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String noteTitle;
	@Column(length = 1500)
	private String noteContent;
	private String noteAuthor;
	private Date noteDate;
	
	public Notes(int id, String noteTitle, String noteContent, String noteAuthor, Date noteDate) {
		super();
		this.id = id;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteAuthor = noteAuthor;
		this.noteDate = noteDate;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getNoteAuthor() {
		return noteAuthor;
	}
	public void setNoteAuthor(String noteAuthor) {
		this.noteAuthor = noteAuthor;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteAuthor="
				+ noteAuthor + ", noteDate=" + noteDate + "]";
	}
	
	
}
