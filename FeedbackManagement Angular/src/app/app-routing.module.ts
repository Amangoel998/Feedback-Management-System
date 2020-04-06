import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StuLoginComponent } from './stu-login/stu-login.component';
import { StudentInfoComponent } from './student-info/student-info.component';
import { GiveFeedbackComponent } from './give-feedback/give-feedback.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';


const routes: Routes = [{path:'stuLogin',component:StuLoginComponent},
{path:'stuActions',component:StudentInfoComponent},
{path:'giveFeedback',component:GiveFeedbackComponent},
{path:'admin',component:AdminLoginComponent},
{path:'adminHome',component:AdminHomeComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
