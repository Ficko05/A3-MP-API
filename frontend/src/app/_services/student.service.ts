import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student } from '../_dto/student';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students: Student[] = [];

  constructor(private http: HttpClient) { }

  getStudents() {
    return this.http.get<Student[]>('/api/students');
}
}
