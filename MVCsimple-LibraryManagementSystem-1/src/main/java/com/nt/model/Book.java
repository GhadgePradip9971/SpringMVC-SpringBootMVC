package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="LibraryTab")
public class Book {
	@Id
	@GeneratedValue
	private long id;
	private String titile;
	private String author;
	private int year;
	

}
