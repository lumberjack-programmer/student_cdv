import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { StudentListComponent } from './components/student-list/student-list.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import {ReactiveFormsModule, FormsModule} from "@angular/forms";
import {StudentService} from "./services/student.service";
import {HttpClientModule} from "@angular/common/http";
import { SearchComponent } from './components/search/search.component';



@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    AddStudentComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
