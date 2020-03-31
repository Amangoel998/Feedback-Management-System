import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student } from './student';
import { Observable } from 'rxjs';
import { BatchOfCourse } from './BatchOfCourse';
import { ProgramInCourse } from './programsInCourse';
import { TrainerPrograms } from './trainerProgram';
import { Feedback } from './feedback';
import { FeedbackService } from './feedback.service';

@Injectable({
  providedIn: 'root'
})
export class StuServiceService {

  constructor(private http: HttpClient,private feedbackSer:FeedbackService) { }
  public tempStudent:Student;
  public flag:boolean=false;
  public studentDb:any[]=[];
 

  getStudents()
  {
   this.http.get<Student[]>('http://localhost:3000/students').subscribe(resp=>{
    for(const d of(resp as any)){
      this.studentDb.push({ id: d.id,
        studentName:d.studentName,
        studentEmail:d.studentEmail,
        password:d.password,
        active:d.active,
        batch:d.batch
      })
    }
   console.log(this.studentDb);
   
   
  });
  }

  addStudent(student:Student)
  {
    return this.http.post('http://localhost:3000/students',student);
  }

  deleteStudent(id:any)
  {
    return this.http.delete('http://localhost:3000/students/'+id);
  }
 
  updateStudent(id:any,student:Student)
  {
    return this.http.put('http://localhost:3000/students/'+id,student);
  }

  getCourse(student:any){
    this.http.get('http://localhost:3000/batchOfCourses').subscribe(re=>{
     
    for(const dd of (re as any))
    {
      if(dd.batch==student.batch)
      {
        
        return dd.CourseId;
        
      }
      
    }
      
    })
        
  }

  getPrograms(courseId:any)
  {
  
    let programList:any[]=[];
    this.http.get('http://localhost:3000/programsInCourses').subscribe(resp=>{
      for(const d of(resp as any))
      {
        if(d.courseId==courseId)
        {
          programList.push(d.programID);
        }
      }

    })
    console.log(programList);
    
    return programList;

  }
  getAvailableFeedback(programList:any)
  { let tempProgramList:any=programList;
    this.feedbackSer.getFeedbacks().subscribe(resp=>{
      for(const d of(resp as any))
      { 
      
        if((d.studentId==this.tempStudent.id)&&(programList.includes(d.programId)))
        { 
          for(let i=0;i<tempProgramList.length;i++)
          {
            if(tempProgramList[i]==d.programId)
            {
              tempProgramList.splice(i,1);
            }
          }
        }
      }
    })
    
    return tempProgramList;
  }

 
}