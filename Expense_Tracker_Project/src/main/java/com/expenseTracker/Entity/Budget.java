package com.expenseTracker.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Budget 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double amount;
	
	private String month;
	
	private int year;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private User user; //Many Budgets can belong to One User 
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Category category; 	//Many Budgets can belong to One Category 
}
