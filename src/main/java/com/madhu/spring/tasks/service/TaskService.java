package com.madhu.spring.tasks.service;

import com.madhu.spring.tasks.domain.Task;

public interface TaskService{
	
	public Iterable<Task> findAllTasks();
    
}