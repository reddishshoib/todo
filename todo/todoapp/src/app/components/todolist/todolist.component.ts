import { Component, OnInit  } from '@angular/core';
import {ApiService} from "../../services/api.service";
import {TodoModel} from "../../models/todo.model";
@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrl: './todolist.component.css'
})
export class TodolistComponent implements OnInit {
  fetchedData: TodoModel[] | undefined ;
  constructor( private  apiService: ApiService) {  }

  ngOnInit():void{
    this.fetchData();
  }
  private fetchData():void {
    this.apiService.getData().subscribe({
      next: (data: TodoModel[]) => {
        this.fetchedData = data;
        console.log(this.fetchedData)
      },
      error: (error) => {
        console.log('Error fetching data:', error);
      }
    });
  }
}
