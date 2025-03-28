package com.expenseTracker.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Income 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double amount;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private String description;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private User user; //Each income belongs to one user
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Category category; //Each income falls into one category
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Payment_Mode payment; //Each income is coming by one payment mode
}
