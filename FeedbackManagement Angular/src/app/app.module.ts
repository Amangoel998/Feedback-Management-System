import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StuLoginComponent } from './stu-login/stu-login.component';
import { ReactiveFormsModule } from "@angular/forms";
import { StudentInfoComponent } from './student-info/student-info.component';
import { RouterModule } from '@angular/router';
import { StuServiceService } from './stu-service.service';
import { GiveFeedbackComponent } from './give-feedback/give-feedback.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { TrainerLoginComponent } from './trainer-login/trainer-login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { TrainerHomeComponent } from './trainer-home/trainer-home.component';

@NgModule({
  declarations: [
    AppComponent,
    StuLoginComponent,
    StudentInfoComponent,
    GiveFeedbackComponent,
    AdminLoginComponent,
    TrainerLoginComponent,
    AdminHomeComponent,
    TrainerHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [StuServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
