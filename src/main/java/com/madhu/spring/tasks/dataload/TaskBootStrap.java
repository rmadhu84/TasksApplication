/**
 * 
 */
package com.madhu.spring.tasks.dataload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.madhu.spring.tasks.domain.Task;
import com.madhu.spring.tasks.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramachandranm1
 *
 */
@Component
@Transactional
@Slf4j
public class TaskBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	TaskRepository taskRepo;

	
	
	
	public TaskBootStrap(TaskRepository taskRepo) {
		super();
		this.taskRepo = taskRepo;
	}




	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		log.info("Starting data load!!");
		taskRepo.saveAll(initialLoad());
		log.info("Data load complete");		
	}




	private List<Task> initialLoad() {
		// TODO Auto-generated method stub
		List<Task> tasks = new ArrayList<Task>();
		LocalDate today = LocalDate.now();

		Task task = new Task();
		task.setName("Create Spring App");
		task.setDueDate((today.plusDays(5)));
		tasks.add(task);
		
		task = new Task();
		task.setName("Create Angular App");
		task.setDueDate((today.plusDays(5)));
		tasks.add(task);
		return tasks;
	
	}
	

}
