import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from './Course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  courseDb:any[]=[];
  constructor(private http:HttpClient) { }

  loadcourses()
  {
    return this.http.get<Course[]>('http://localhost:3000/courses').subscribe(resp=>{
      for(const d of(resp as any)){
        this.courseDb.push({ id: d.id,
          courseName:d.courseName,
          active:d.active
        })
      }
     console.log(this.courseDb);
     
     
    });;
  }

  addcourse(course:Course)
  {
    return this.http.post('http://localhost:3000/courses',course);
  }
  
  deletecourse(courseId:any)
  {
    return this.http.delete('http://localhost:3000/courses/'+courseId);
  }
  updatecourse(id:any,course:Course)
  {
    return this.http.put('http://localhost:3000/courses/'+id,course);
  }
}
