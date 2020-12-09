import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { STUDENTS } from '../mock-students';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent{

  students = STUDENTS;
  selectedStudent: Student;
  
  constructor() { }

  //ngOnInit(): void {
  //}

  onSelect(student: Student): void {
    this.selectedStudent = student;
  }

}
