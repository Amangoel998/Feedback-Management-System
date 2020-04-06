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

@NgModule({
  declarations: [
    AppComponent,
    StuLoginComponent,
    StudentInfoComponent,
    GiveFeedbackComponent,
    AdminLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
  ],
  providers: [StuServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
