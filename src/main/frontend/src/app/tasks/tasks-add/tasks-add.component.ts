import { Component, OnInit } from '@angular/core';
import { TaskclientService } from '../service/taskclient.service';
import { Task } from '../tasks.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: ['./tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {

  addTaskValue: string = null;

  constructor(private service: TaskclientService) { }
  subscription: Subscription;

  ngOnInit() {
  }

  ngOnDestroy(): void {
    //Called once, before the instance is destroyed.
    //Add 'implements OnDestroy' to the class.
    this.subscription.unsubscribe();
  }

  onTaskAdd(event) {
    let task: Task = new Task(event.target.value, false, this.getDate());
    this.service.addTask(task).subscribe((newtask: Task) => {
      this.addTaskValue = 'Add New Task';
      this.service.onTaskAdded.emit(newtask);
    });
  }

  getDate() {
    let date: Date = new Date();
    let month: String = ("00" + (date.getMonth() + 1).toString()).substr(-2);
    let dte: String = date.getDate().toString();
    let year: String = date.getFullYear().toString();
    return (month + "/" + dte + "/" + year);
  }
}
