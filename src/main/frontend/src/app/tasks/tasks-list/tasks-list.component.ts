import { Component, OnInit } from '@angular/core';
import { Task } from '../tasks.model';
import { TaskclientService } from '../service/taskclient.service';
import { Observable, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
@Component({
	selector: 'app-tasks-list',
	templateUrl: './tasks-list.component.html',
	styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {
	/* 
	//Using the Default way to subscribing of observable.
	//When you do not subscribe to an observable, you need to use async pipe in the *ngFor 
	//	to subscribe to the observable. Doing this is much cleaner way to subscribe, as this takes 
	//	care of unsubscribtion when the component is destroyed.
	
	//
	//subscription : Subscription;
	*/
	tasks:Task[];
	subscription: Subscription;
	//tasks: Observable<Task[]>; //use this when invoking getAllTasks without subscribe.

	constructor(private service: TaskclientService) { }

	ngOnInit() {

		/* Adding elements to an array
		this.tasks.push(new Task(1, "Task 1", true,"01/17/2020"));
		this.tasks.push(new Task(2, "Task 2", false,"01/12/2020"));
		this.tasks.push(new Task(3, "Task 3", false,"01/15/2020"));
		this.tasks.push(new Task(4, "Task 4", true, "01/20/2020"));*/

		// this.tasks = this.service.getAllTasks();

		/* Using the Default way to subscribing of observable.*/
		this.subscription = this.service.getAllTasks().subscribe((response)=>this.tasks=response);
		

		this.service.onTaskAdded.subscribe((task: Task) => {
			this.tasks.push(task);
		})
	}


	ngOnDestroy() {
		console.log("Unsubscribing!!")
		this.subscription.unsubscribe();
	}


	getDueDateLabel(task: Task) {
		return task.completed ? "badge-pill badge-success" : "badge-pill badge-primary"
	}

	onTaskChange(event, task) {
		console.log("Task saved");
		//subscribe() is required while writing data back to db.
		this.service.saveTask(task, event.target.checked).subscribe();
	}

}
