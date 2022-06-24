import {Component, OnInit} from '@angular/core';
import {StudentService} from "../../services/student.service";
import { FormGroup, FormControl } from '@angular/forms';
import {Student} from "../common/student";


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.scss']
})
export class AddStudentComponent implements OnInit {

  students: Student[] = [];

  profileForm = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    branch: new FormControl(''),
  });

  constructor(private studentService: StudentService) {
  }


  ngOnInit() {
    this.getStudentList();
  }

  getStudentList() {
    this.studentService.getStudentList().subscribe(
      data => {
        this.students = data;
      }
    );
  }


  addNewStudent() {

    // @ts-ignore
    let student: Student = new Student(this.profileForm.value.name.charAt(0).toUpperCase() + this.profileForm.value.name.slice(1), this.profileForm.value.email, this.profileForm.value.branch);

    this.studentService.createStudent(student).subscribe(student => this.students.push(student));
    this.profileForm.reset();
  }
}
