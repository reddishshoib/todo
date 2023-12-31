import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TodolistComponent } from './todolist/todolist.component';
import {HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [
    TodolistComponent
  ],
  exports: [
    TodolistComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class ComponentsModule { }
