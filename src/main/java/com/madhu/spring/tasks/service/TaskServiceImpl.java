package com.madhu.spring.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.spring.tasks.domain.Task;
import com.madhu.spring.tasks.repository.TaskRepository;



@Service
public class TaskServiceImpl implements TaskService{

	TaskRepository taskRepo;
	
	@Override
	public Iterable<Task> findAllTasks() {
		return this.taskRepo.findAll();
	}
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepo) {
		super();
		this.taskRepo = taskRepo;
	}

	@Override
	public Task save(Task task) {
		return this.taskRepo.save(task);
	}

	public void deleteById(Long id){
		this.taskRepo.deleteById(id);
	}

	@Override
	public Task findTaskById(Long id) {
		return this.taskRepo.findById(id).get();
	}

	public void deleteTask(Task task){
		this.taskRepo.delete(task);
	}
}