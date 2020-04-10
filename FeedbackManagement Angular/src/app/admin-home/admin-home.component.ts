import { Component, OnInit } from '@angular/core';
import { StuServiceService } from '../stu-service.service';
import { Student } from '../student';
import { TrainersService } from '../trainers.service';
import { Trainer } from '../Trainer';
import { Course } from '../Course';
import { CourseService } from '../course.service';
import { Program } from '../Program';
import { ProgramInCourse } from '../programsInCourse';
import { ProgramService } from '../program.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private router: Router, public programServ: ProgramService, public studServ: StuServiceService, public trainServ: TrainersService, public courseServ: CourseService) { }

  public localProgarms: ProgramInCourse[] = [];
  programsForTrainer=[];
  showTrainerPrograms:boolean=false;
  viewFeedbacksForProgram:boolean=false;
  feedbacksForProgram=[];
  feedbackDefaulters=[];
  viewTrainerProgramsButton:string="Show Programs";
  show: boolean = false;
  showProgramForm: boolean = false;
  viewProgramButton: string = "View Programs"
  ngOnInit(): void {
    this.studServ.getStudents();
    this.trainServ.loadTrainers();
    this.courseServ.loadcourses();
    this.programServ.loadPrograms();
  }

  deleteStudent(studentID) {
    this.studServ.deleteStudent(studentID).subscribe();
  }
  addStudent() {
    var id = (<HTMLInputElement>document.getElementById('stuId')).value;
    var name = (<HTMLInputElement>document.getElementById('stuName')).value;
    var email = (<HTMLInputElement>document.getElementById('stuEmail')).value;
    var pass = (<HTMLInputElement>document.getElementById('pass')).value;
    var batch = (<HTMLInputElement>document.getElementById('batch')).value;
    if (id != null && name != null && email != null && pass != null && batch != null) {
      var tempStudent: Student = new Student(id, name, email, pass, batch, true);
      this.studServ.addStudent(tempStudent).subscribe();
    }
  }

  deleteTrainer(trainerId) {
    this.trainServ.deleteTrainer(trainerId).subscribe();
  }
  addTrainer() {
    var id = (<HTMLInputElement>document.getElementById('trainerId')).value;
    var name = (<HTMLInputElement>document.getElementById('trainerName')).value;
    var email = (<HTMLInputElement>document.getElementById('trainerEmail')).value;
    var pass = (<HTMLInputElement>document.getElementById('trainerPass')).value;
    var skills = [];
    if (id != null && name != null && email != null && pass != null) {
      var tempTrainer: Trainer = new Trainer(id, name, email, pass, true, skills);
      this.trainServ.addTrainer(tempTrainer).subscribe();
    }
  }

  showFormProgramCourse() {
    this.showProgramForm = !this.showProgramForm;
  }

  loadProgramsForCourse(courseId) {
    this.courseServ.setCourseById(courseId);
    this.show = !this.show;
    if (this.show) {
      this.localProgarms = this.courseServ.getProgramsInCourse(courseId);
      this.viewProgramButton = "Hide Programs";
    }
    else {
      this.viewProgramButton = "View Programs";
    }


  }

  deleteCourse(courseId) {
    this.courseServ.deletecourse(courseId).subscribe();
  }

  deleteProgram(programId) {
    this.programServ.deleteProgram(programId).subscribe();
  }

  addProgram() {
    var id = (<HTMLInputElement>document.getElementById('programId')).value;
    var name = (<HTMLInputElement>document.getElementById('programName')).value;
    if (id != null && name != null) {
      var tempProgram: Program = new Program(id, name, true);
      this.programServ.addProgram(tempProgram).subscribe();
    }
  }
  logout() {
    this.router.navigateByUrl('/admin');
  }
  addProgramToCourse() {
    var courseId = (<HTMLInputElement>document.getElementById('course-courseId')).value;
    var programId = (<HTMLInputElement>document.getElementById('course-programId')).value;
    var startDate = (<HTMLInputElement>document.getElementById('start-date')).value;
    var endDate = (<HTMLInputElement>document.getElementById('end-date')).value;
    if (courseId != null && programId != null && startDate != null && endDate != null) {
      let programInCourse: ProgramInCourse = new ProgramInCourse(programId, courseId, startDate, endDate);
      this.localProgarms.push(programInCourse);
      this.courseServ.addProgramToCourse(programInCourse).subscribe();
    }

  }

  removeFromCourse(id) {
    for (let i = 0; i < this.localProgarms.length; i++) {
      if (this.localProgarms[i].id == id) {
        this.localProgarms.splice(i, 1);
      }
    }
    this.courseServ.removeProgramFromCourse(id).subscribe();
  }


  showProgramsForTrainer(id)
  { this.showTrainerPrograms=!this.showTrainerPrograms;
    this.trainServ.setLocalTrainerById(id);
    if(this.showTrainerPrograms)
    {
    this.programsForTrainer=this.trainServ.getProgramsAndBatch();
    this.viewTrainerProgramsButton="Hide Programs"
    }
    else{
      this.viewTrainerProgramsButton="Show Programs"
      this.trainServ.localTrainer=null;
      this.programsForTrainer.splice(0);
    }

  }

  showFeedbacksForProgram(programId,batch)
  { this.programServ.setProgramById(programId);
    this.viewFeedbacksForProgram=!this.viewFeedbacksForProgram;
    if(this.viewFeedbacksForProgram)
    {
      this.feedbacksForProgram=this.trainServ.viewFeedbacksbyProgram(programId);
      this.feedbackDefaulters=this.trainServ.viewFeedBackDefaulters(programId,batch);
    }

  
  }

  addCourse()
  {
    var courseId = (<HTMLInputElement>document.getElementById('new-courseId')).value;
    var courseName = (<HTMLInputElement>document.getElementById('new-courseName')).value;
    if(courseId!=null&&courseName!=null)
    {
      let course:Course=new Course(courseId,courseName,true);
      this.courseServ.addcourse(course).subscribe();
    }
  }

}
