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
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { TrainerPrograms } from '../trainerProgram';
import { BatchOfCourse } from '../BatchOfCourse';

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
  showSkillsFlag:boolean=false;
  feedbacksForProgram=[];
  tempSkills=[];
  batches=[];
  trainerProgramToggle:boolean=false;
  batchesForCourse=[];
  feedbackDefaulters=[];
  viewTrainerProgramsButton:string="Show Programs";
  show: boolean = false;
  showProgramForm: boolean = false;
  viewProgramButton: string = "View Programs"
  showBatchForCourse:boolean=false;


  studentForm=new FormGroup({
  studentId:new FormControl(null,Validators.required),  
  studentName:new FormControl(null,Validators.required),  
  studentEmail:new FormControl(null,[Validators.email,Validators.required]),  
  password:new FormControl(null,Validators.required),
  batchesDropdown:new FormControl(null,Validators.required)
  })
  
  trainerPrograms=new FormGroup({
    programId:new FormControl(null,Validators.required),
    batch:new FormControl(null,Validators.required)
  })

  newTrainerForm=new FormGroup({
    trainerId:new FormControl(null,Validators.required),
    trainerName:new FormControl(null,Validators.required),
    trainerEmail:new FormControl(null,[Validators.email,Validators.required]),
    password:new FormControl(null,Validators.required)

  })

  newBatchForm=new FormGroup({
    batch:new FormControl(null,Validators.required)
  })

  newCourseForm=new FormGroup({
    courseId:new FormControl(null,Validators.required),
    courseName:new FormControl(null,Validators.required)
  })

  newProgramForCourse=new FormGroup({
    programId:new FormControl(null,Validators.required),
    startDate:new FormControl(null,Validators.required),
    endDate:new FormControl(null,Validators.required)
  })

  newProgramForm=new FormGroup({
    programId:new FormControl(null,Validators.required),
    programName:new FormControl(null,Validators.required)
  })





  ngOnInit(): void {
    this.studServ.getStudents();
    this.trainServ.loadTrainers();
    this.courseServ.loadcourses();
    this.programServ.loadPrograms();
    this.batches=this.courseServ.getAllBatches();
  }

  manageBatches(courseId)
{
  this.showBatchForCourse=!this.showBatchForCourse;
  if(this.showBatchForCourse)
  {
    this.courseServ.setCourseById(courseId);
    this.batchesForCourse=this.courseServ.getBatchesForCourse(courseId);
  }
  else{
    this.courseServ.localCourse=null;
    this.batchesForCourse=null;
  }
}

addBatches()
{
  var batch=this.newBatchForm.get('batch').value;
  var courseId=this.courseServ.localCourse.id;
  if(this.newBatchForm.valid) 
  {
    let batchForCourse:BatchOfCourse=new BatchOfCourse(batch,courseId);    
    this.courseServ.addBatchesforCourse(batchForCourse).subscribe();
    this.batchesForCourse.push(batchForCourse);
    this.batches.push(batch);
  } 


  
}

removeBatch(id)
{
 this.courseServ.removeBatch(id).subscribe();
 for(let i=0;i<this.batchesForCourse.length;i++)
 {
   if(this.batchesForCourse[i].id==id)
   {
     this.batchesForCourse.splice(i,1);
   }
 }
}

  addProgramForTrainer()
  {
    var programId=this.trainerPrograms.get('programId').value;
    var batch=this.trainerPrograms.get('batch').value;
    var trainerId=this.trainServ.localTrainer.id;

    if(this.trainerPrograms.valid)
    { var trainerProgram:TrainerPrograms=new TrainerPrograms(trainerId,programId,batch);
      this.trainServ.addTrainerProgram(trainerProgram).subscribe();
      this.programsForTrainer.push(trainerProgram);
    }
    else{
      this.trainServ.localTrainer=null;
      this.programsForTrainer=null;
    }

  }

  removeTrainerProgram(id)
  { 
    this.trainServ.removeTrainerProgram(id).subscribe();
    for(let i=0;i<this.programsForTrainer.length;i++)
    {
      if(this.programsForTrainer[i].id==id)
      {
        this.programsForTrainer.splice(i,1);
      }
    }
  }

  deleteStudent(studentID) {
    this.studServ.deleteStudent(studentID).subscribe();
  }

  managePrograms(trainerId)
  { 
    this.trainerProgramToggle=!this.trainerProgramToggle;
    if(this.trainerProgramToggle)
    {
    this.trainServ.setLocalTrainerById(trainerId);
    this.programsForTrainer=this.trainServ.getProgramsAndBatch();
    }
    else
    {this.trainServ.localTrainer=null;
      this.programsForTrainer=null;
    }

  }
  addStudent() {
    var form:FormGroup=this.studentForm;
    var id = form.get('studentId').value;
    var name = form.get('studentName').value;
    var email = form.get('studentEmail').value;
    var pass = form.get('password').value;
    var batch = form.get('batchesDropdown').value;
    if (form.valid) {
      var tempStudent: Student = new Student(id, name, email, pass, batch, true);
      this.studServ.addStudent(tempStudent).subscribe();
    }
  }

  deleteTrainer(trainerId) {
    this.trainServ.deleteTrainer(trainerId).subscribe();
  }
  addTrainer() {
    var trainerForm:FormGroup= this.newTrainerForm;
    var id = trainerForm.get('trainerId').value;
    var name = trainerForm.get('trainerName').value;
    var email =trainerForm.get('trainerEmail').value;
    var pass = trainerForm.get('password').value;
    var skills = [];
    if (trainerForm.valid) {
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
    var id = this.newProgramForm.get('programId').value;
    var name = this.newProgramForm.get('programName').value;
    if (this.newProgramForm.valid) {
      var tempProgram: Program = new Program(id, name, true);
      this.programServ.addProgram(tempProgram).subscribe();
    }
  }
  logout() {
    this.router.navigateByUrl('/admin');
  }
  addProgramToCourse() {
    var courseId = this.courseServ.localCourse.id;
    var programId = this.newProgramForCourse.get('programId').value;
    var startDate =  this.newProgramForCourse.get('startDate').value;
    var endDate =  this.newProgramForCourse.get('endDate').value;
    if (this.newProgramForCourse.valid) {
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
    { console.log(batch);
    
      this.feedbacksForProgram=this.trainServ.viewFeedbacksbyProgram(programId);
      this.feedbackDefaulters=this.trainServ.viewFeedBackDefaulters(programId,batch);
    }

  
  }

  addCourse()
  {
    var courseId = this.newCourseForm.get('courseId').value;
    var courseName = this.newCourseForm.get('courseName').value;
    if(this.newCourseForm.valid)
    {
      let course:Course=new Course(courseId,courseName,true);
      this.courseServ.addcourse(course).subscribe();
    }
  }

  manageSkills(trainerId)
  { this.trainServ.setLocalTrainerById(trainerId);
    this.showSkillsFlag=!this.showSkillsFlag;

    if(this.showSkillsFlag){
    this.tempSkills=this.trainServ.getSkills();
    }

  }

  deleteSkill(skill)
  {
    this.trainServ.deleteSkills(skill);
    this.tempSkills=this.trainServ.getSkills();

  }

  addSkill()
  {
    var skill=(<HTMLInputElement>document.getElementById('skill')).value;
    this.trainServ.addskills(skill);
    this.tempSkills=this.trainServ.getSkills();
  }

}
