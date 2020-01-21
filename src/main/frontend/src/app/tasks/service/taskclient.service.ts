import { Injectable, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from '../tasks.model';
import { EventEmitter } from '@angular/core';
@Injectable({
	providedIn: 'root'
})
export class TaskclientService {

	constructor(private TaskClient: HttpClient) { }

	onTaskAdded: EventEmitter<Task> = new EventEmitter();

	getAllTasks(){
		return this.TaskClient.get<any>('/api/tasks/getAllTasks');
	}
	
	saveTask(task : Task, checked : boolean){
		task.completed = checked;
		return this.TaskClient.post('/api/tasks/save', task);
		
	}

	addTask(task: Task){
		return this.saveTask(task, false);
	}
	
/*	getEmployeesList(): Observable<any> {
    return this.TaskClient.get(`${this.baseUrl}`);
  }*/
}
