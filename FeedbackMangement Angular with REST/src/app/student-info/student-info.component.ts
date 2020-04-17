import { Component, OnInit } from '@angular/core';
import { StuLoginComponent } from '../stu-login/stu-login.component';
import { Student } from '../student';
import { StuServiceService } from '../stu-service.service';
import { Course } from '../Course';
import { FeedbackService } from '../feedback.service';
import { TrainersService } from '../trainers.service';
import { Router } from '@angular/router';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  constructor(public progServ:ProgramService,public studSer:StuServiceService,public tain:TrainersService ,private router:Router) { }
 public student:Student;

  ngOnInit(): void {
       this.setStudent();

}
setStudent()
{
  
  this.student=this.studSer.tempStudent;
  this.setCourse(this.studSer.tempStudent.batch);
}
setCourse(batch:string)
{
  this.studSer.getCourse(batch);
  
}


getForm(programId:any)
{
  this.tain.getTrainerByProgram(programId,this.student.batch);
  this.progServ.setProgramById(programId);
  this.router.navigateByUrl('giveFeedback');
}
logout()
{ this.student=null;
  this.router.navigateByUrl('/stuLogin')
}

}