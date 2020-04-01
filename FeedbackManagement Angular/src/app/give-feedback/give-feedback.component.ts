import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { Trainer } from '../Trainer';
import { Program } from '../Program';
import { StuServiceService } from '../stu-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { TrainersService } from '../trainers.service';
import { ProgramService } from '../program.service';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-give-feedback',
  templateUrl: './give-feedback.component.html',
  styleUrls: ['./give-feedback.component.css']
})
export class GiveFeedbackComponent implements OnInit {
  student:Student;
  trainer:Trainer;
  program:Program;
  constructor(private stuSer:StuServiceService,private trainerService:TrainersService,private programService:ProgramService,private feedbackService:FeedbackService) { }

  ngOnInit(): void {
    this.student=this.stuSer.tempStudent;
    this.trainer=this.trainerService.localTrainer;
    this.program=this.programService.localProgram;
  }

  feedbackForm=new FormGroup({
    ques1: new FormControl(''),
    ques2: new FormControl(''),
    ques3: new FormControl(''),
    ques4: new FormControl(''),
    ques5: new FormControl(''),
    comments: new FormControl(''),
    suggestions: new FormControl('')
  });

  submitFeedBack()
  { var feedbackid:string="FDB"+Number(this.feedbackService.feedbacksDb[this.feedbackService.feedbacksDb.length-1].id.toString().substring(2))+1;
    var ques:number[]=[this.feedbackForm.get('ques1').value,
                        this.feedbackForm.get('ques2').value,
                        this.feedbackForm.get('ques3').value,
                        this.feedbackForm.get('ques4').value,
                        this.feedbackForm.get('ques5').value
                      ];
    var comments=this.feedbackForm.get('comments').value;
    var suggestions=this.feedbackForm.get('suggestions').value;
    var feedback:Feedback=new Feedback(feedbackid,this.student.id,this.trainer.id,this.program.id,ques,comments,suggestions);
    this.feedbackService.postFeedback(feedback).subscribe(resp => {
      console.log(resp);
      
    });;
  }

}
