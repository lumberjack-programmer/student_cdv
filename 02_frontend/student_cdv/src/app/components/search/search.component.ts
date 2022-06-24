import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  doSearch (value : string) {
    this.router.navigateByUrl(`/search/${value}`);
  }


}
