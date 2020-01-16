package com.madhu.spring.tasks.repository;

import org.springframework.data.repository.CrudRepository;

import com.madhu.spring.tasks.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>  {

}