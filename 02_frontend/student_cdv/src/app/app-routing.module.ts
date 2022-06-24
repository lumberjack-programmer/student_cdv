import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from "./components/student-list/student-list.component";
import {AddStudentComponent} from "./components/add-student/add-student.component";

const routes: Routes = [
  {path: 'view-student', component: StudentListComponent},
  {path: 'search/:keyword', component: StudentListComponent},
  {path: 'add-student', component: AddStudentComponent},
  {path: '', redirectTo: 'view-student', pathMatch: 'full'},
  {path: '**',  redirectTo: 'view-student', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
