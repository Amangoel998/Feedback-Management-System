import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StuLoginComponent } from './stu-login/stu-login.component';
import { StudentInfoComponent } from './student-info/student-info.component';


const routes: Routes = [{path:'stuLogin',component:StuLoginComponent},
{path:'stuActions',component:StudentInfoComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
