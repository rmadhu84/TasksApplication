/**
 * 
 */
package com.madhu.spring.tasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.madhu.spring.tasks.POJO.Greet;
import com.madhu.spring.tasks.domain.Task;
import com.madhu.spring.tasks.service.TaskService;

/**
 * @author ramachandranm1
 *
 */
@RestController
@RequestMapping(value="/Tasks")
public class Controller {

	TaskService taskService;
	
	@RequestMapping(value="/greet")
	public ResponseEntity<Object> hello(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}

	@GetMapping
	@RequestMapping(value="/greetings")
	public ResponseEntity<Greet> greeting(){
		Greet greet = new Greet();
		greet.setMessage("Greetings from VsCode!!");
		return ResponseEntity.status(HttpStatus.OK).body(greet);
	}
	
	@GetMapping("/getAllTasks")
	public ResponseEntity<Object> getAllTasks() {
		Iterable<Task> tasks = taskService.findAllTasks();
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}

	@PostMapping("/save")
	public Task save(@RequestBody Task task){
		return this.taskService.save(task);
	}

	@Autowired
	public Controller(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	
}
