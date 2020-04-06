import { Component, OnInit } from '@angular/core';
import { StuServiceService } from '../stu-service.service';
import { Student } from '../student';
import { TrainersService } from '../trainers.service';
import { Trainer } from '../Trainer';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(public studServ:StuServiceService,public trainServ:TrainersService) { }


  ngOnInit(): void {
    this.studServ.getStudents();
    this.trainServ.loadTrainers();
  }

  deleteStudent(studentID)
  {
    this.studServ.deleteStudent(studentID).subscribe();
  }
  addStudent()
  {
    var id=(<HTMLInputElement>document.getElementById('stuId')).value;
    var name=(<HTMLInputElement>document.getElementById('stuName')).value;
    var email=(<HTMLInputElement>document.getElementById('stuEmail')).value;
    var pass=(<HTMLInputElement>document.getElementById('pass')).value;
    var batch=(<HTMLInputElement>document.getElementById('batch')).value;
    if(id!=null&&name!=null&&email!=null&&pass!=null&&batch!=null)
    {
      var tempStudent:Student=new Student(id,name,email,pass,batch,true);
      this.studServ.addStudent(tempStudent).subscribe();
    }
  }
  
  deleteTrainer(trainerId)
  {
    this.trainServ.deleteTrainer(trainerId).subscribe();
  }
  addTrainer()
  {
    var id=(<HTMLInputElement>document.getElementById('trainerId')).value;
    var name=(<HTMLInputElement>document.getElementById('trainerName')).value;
    var email=(<HTMLInputElement>document.getElementById('trainerEmail')).value;
    var pass=(<HTMLInputElement>document.getElementById('trainerPass')).value;
    var skills=[];
    if(id!=null&&name!=null&&email!=null&&pass!=null)
    {
    var tempTrainer:Trainer=new Trainer(id,name,email,pass,true,skills);
    this.trainServ.addTrainer(tempTrainer).subscribe();
    }
  }

}
