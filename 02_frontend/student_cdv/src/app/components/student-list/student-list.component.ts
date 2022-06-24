import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../services/student.service";
import {map, Observable, Subject} from "rxjs";
import {FormControl, FormGroup} from "@angular/forms";
import {Student} from "../common/student";
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {

  // @ts-ignore
  students: Student[] = [];

  // @ts-ignore
  updateStudentModel: Student;

  // @ts-ignore
  private searchMode : boolean;

  constructor(private studentService: StudentService, private modalService: NgbModal, private route: ActivatedRoute) { }

  ngOnInit() {
  this.route.paramMap.subscribe(() => {
    this.getStudentList();
  });
  }

  // @ts-ignore
  profileForm: FormGroup;

  editStudent() {
    // @ts-ignore
    let student: Student = new Student(this.profileForm.value.name, this.profileForm.value.email, this.profileForm.value.branch);

    this.studentService.updateStudent(this.updateStudentModel.id, student);
    // @ts-ignore
    this.updateStudentId = undefined;
  }


  getStudentList() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchProducts();
    } else  {
      this.handleListProducts();
    }
  }

    handleListProducts () {
      this.studentService.getStudentList().subscribe(
        data => {
          this.students = data;
        }
      );
    }

    handleSearchProducts () {

      // @ts-ignore
      const theKeyword: string = this.route.snapshot.paramMap.get('keyword');

      this.studentService.searchStudents(theKeyword).subscribe(
        data => {
          this.students = data;
        }
      );
    }

  deleteStudent (id: number) {
    this.studentService.deleteStudent(id).subscribe(student => {this.students.splice(student); this.getStudentList();});
  }

  closeResult = '';

  open(content: any, id: number) {
    // @ts-ignore
    this.updateStudentModel = this.students.find(student => student.id === id);

    this.profileForm = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      branch: new FormControl(''),
    });

    this.profileForm.setValue({name: this.updateStudentModel.name, email: this.updateStudentModel.email, branch: this.updateStudentModel.branch})


    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      // this.closeResult = `Closed with: ${result}`;
      this.getStudentList();
    }, (reason) => {
      // this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      this.getStudentList();
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
