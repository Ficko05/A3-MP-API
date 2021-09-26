import { Component, OnInit } from '@angular/core';
import { Student } from '../_dto/student';
import { StudentService } from '../_services/student.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.studentService.getStudents().subscribe(res => this.students = res);

  }

}
