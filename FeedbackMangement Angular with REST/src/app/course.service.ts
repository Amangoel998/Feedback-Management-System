import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from './Course';
import { ProgramService } from './program.service';
import { Program } from './Program';
import { ProgramInCourse } from './programsInCourse';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  courseDb: any[] = [];
  localCourse:Course;
  constructor(private http: HttpClient, private programSer: ProgramService) { }

  loadcourses() {
    return this.http.get<Course[]>('http://localhost:3000/courses').subscribe(resp => {
      for (const d of (resp as any)) {
        this.courseDb.push({
          id: d.id,
          courseName: d.courseName,
          active: d.active
        })
      }
      console.log(this.courseDb);


    });;
  }

  addcourse(course: Course) {
    this.courseDb.push(course);
    return this.http.post('http://localhost:3000/courses', course);
  }

  deletecourse(courseId: any) {
    for(let i=0;i<this.courseDb.length;i++)
    {
      if(this.courseDb[i].id==courseId)
      {
        this.courseDb.splice(i,1);
      }
    }
    return this.http.delete('http://localhost:3000/courses/' + courseId);
  }
  updatecourse(id: any, course: Course) {
    return this.http.put('http://localhost:3000/courses/' + id, course);
  }

  getProgramsInCourse(courseId) {
    let programs: ProgramInCourse[] = [];
    this.http.get('http://localhost:3000/programsInCourses').subscribe(resp => {
      for (const d of (resp as any)) {
        if (d.courseId == courseId) {
              programs.push(d);
            }
      }
    }
    )
    return programs;
  }
  setCourseById(courseId)
  {
    this.http.get('http://localhost:3000/courses/' + courseId).subscribe((resp:Course)=>
    this.localCourse=resp
    )
  }

  addProgramToCourse(programInCourse:ProgramInCourse)
  {
    return this.http.post('http://localhost:3000/programsInCourses',programInCourse);
  }
  removeProgramFromCourse(id)
  {
    return this.http.delete('http://localhost:3000/programsInCourses/'+id);
  }
}

