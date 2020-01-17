package com.madhu.spring.tasks.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Task{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dueDate;
	private Boolean completed;

	public Task(){
		this.completed = false;
	}
}