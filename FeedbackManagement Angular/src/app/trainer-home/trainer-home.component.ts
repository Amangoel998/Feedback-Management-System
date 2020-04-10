import { Component, OnInit } from '@angular/core';
import { TrainersService } from '../trainers.service';
import { ProgramService } from '../program.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainer-home',
  templateUrl: './trainer-home.component.html',
  styleUrls: ['./trainer-home.component.css']
})
export class TrainerHomeComponent implements OnInit {
  trainerPrograms=[];
  trainerFeedbacks=[];
  programFeedbacks=[];
  feedbackDefaulters=[];
  show:boolean=false;
  btnName:String="View FeedBacks";

  constructor(public trainerService:TrainersService,public progServ:ProgramService,private router:Router) { }

  ngOnInit(): void {
    this.trainerPrograms=this.trainerService.getProgramsAndBatch();
    this.trainerFeedbacks=this.trainerService.viewFeedbacks();
  }

  viewFeedback(programId,batch) {
    this.show = !this.show;

    if(this.show) { 
      this.btnName = "Hide FeedBacks";
      this.programFeedbacks=this.trainerService.viewFeedbacksbyProgram(programId);
      this.progServ.setProgramById(programId);
      
    this.feedbackDefaulters=this.trainerService.viewFeedBackDefaulters(programId,batch);

    }
    else
      this.btnName = "Show FeedBacks";
  }

  logout()
  { this.trainerService.localTrainer=null;
    this.trainerPrograms=null;
  this.trainerFeedbacks=null;
  this.programFeedbacks=null;
  this.feedbackDefaulters=null;
    this.router.navigateByUrl('/trainer')
  }

}
