import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TodoModel} from "../models/todo.model";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080';

  constructor(private  http:HttpClient) { }
  getData(): Observable<any> {
    return this.http.get<TodoModel[]>(`${this.baseUrl}/getall`);
  }
}
