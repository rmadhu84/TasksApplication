/**
 * 
 */
package com.madhu.spring.tasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.madhu.spring.tasks.POJO.Greet;
import com.madhu.spring.tasks.domain.Task;
import com.madhu.spring.tasks.service.TaskService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramachandranm1
 *
 */
@Slf4j
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value="/api/tasks")
public class Controller {

	TaskService taskService;
	
	Map<String, String> map = new HashMap<String, String>();

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
		log.info("Getting all Tasks");
		Iterable<Task> tasks = taskService.findAllTasks();
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}

	@PostMapping("/save")
	public Task save(@RequestBody Task task){
		return this.taskService.save(task);
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable String id){
		this.taskService.deleteById(new Long(id));
	}

	@GetMapping
	@RequestMapping("/findTask")
	public Task find(@RequestParam String id){
		return this.taskService.findTaskById(new Long(id));
	}

	@Autowired
	public Controller(TaskService taskService, @Qualifier("getTestMap1") HashMap<String, String> mapParam) {
		super();
		this.taskService = taskService;
		this.map = mapParam;
	}
	
	@RequestMapping("/deleteTask")
	public void deleteTask(@RequestBody Task task){
		this.taskService.deleteTask(task);
	}

	@GetMapping("/getMap")
	public ResponseEntity<Object> getMap(){
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

	
}
