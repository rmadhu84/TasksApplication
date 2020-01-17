import { Component, OnInit } from '@angular/core';
import { Task } from '../tasks.model';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks:Task[]=[];
  constructor() { }

  ngOnInit() {
    this.tasks.push(new Task(1, "Task 1", true,"01/17/2020"));
    this.tasks.push(new Task(2, "Task 2", false,"01/12/2020"));
    this.tasks.push(new Task(3, "Task 3", false,"01/15/2020"));
  }

  getDueDateLabel(task:Task){
    return task.completed ? "badge-pill badge-success":"badge-pill badge-primary"
  }

  onTaskChange(event, task){
    console.log("Task saved");
  }

}
