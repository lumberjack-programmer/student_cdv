import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, Subscription} from "rxjs";
import {Student} from "../components/common/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }


  searchStudents (theKeyword: string): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}students/${theKeyword}`);
  }

  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'students');
  }

  createStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.baseUrl}students`, student);
  }


  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}students/${id}`, { responseType: 'text' });
  }

  getStudent(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}students/${id}`);
  }

  updateStudent(id: number, student: Student): Subscription {
    student.id = id;
    return this.http.put(`${this.baseUrl}students/${id}`, student).subscribe(
      data => {console.log(data);
      });


  }

}
