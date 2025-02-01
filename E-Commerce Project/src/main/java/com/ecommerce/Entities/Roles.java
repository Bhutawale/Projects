package com.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Roles 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Enumerated(EnumType.STRING)
	private UserRole roleName;
}
