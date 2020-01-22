package com.madhu.spring.tasks.service;

import com.madhu.spring.tasks.domain.Task;

public interface TaskService{
	
	public Iterable<Task> findAllTasks();
	public Task save(Task task);
	public void deleteById(Long id);
	public Task findTaskById(Long id);
    
}