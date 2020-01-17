import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  private _title: string = "My Tasks List";

  constructor() {

  }

  ngOnInit() {
  }

  get title() {
    return this._title;
  }


}
