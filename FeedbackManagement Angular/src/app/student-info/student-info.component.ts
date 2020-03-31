import { Component, OnInit } from '@angular/core';
import { StuLoginComponent } from '../stu-login/stu-login.component';
import { Student } from '../student';
import { StuServiceService } from '../stu-service.service';
import { Course } from '../Course';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  constructor(private studSer:StuServiceService) { }
 public student:Student;
 public trainers:string[];
 courseId:any;
  programsEnrolled:any[]=[];
  availableFeedbacks:any[]=[];

  ngOnInit(): void {
    this.student=this.studSer.tempStudent;
    
    this.setCourse();

    

}
setCourse()
{
  this.courseId=this.studSer.getCourse(this.student);
  this.setPrograms(this.courseId);
}

setPrograms(courseId:any)
{
  this.programsEnrolled=this.studSer.getPrograms(courseId);
  this.setFeedbacks(this.programsEnrolled);
}

setFeedbacks(programIds:any[])
{
  
  this.availableFeedbacks =this.studSer.getAvailableFeedback(programIds);
}


getForm(studentId:any,programId:any)
{
  
}

}