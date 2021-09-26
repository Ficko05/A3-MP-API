import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { StudypointsComponent } from './studypoints/studypoints.component';

const routes: Routes = [
  {
    path: 'students',
    component: StudentsComponent,
    data: { title: 'Students' }
  },
  {
    path: 'studypoints',
    component: StudypointsComponent,
    data: { title: 'Studypoints' }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
