import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { Trainer } from '../Trainer';
import { Program } from '../Program';
import { StuServiceService } from '../stu-service.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TrainersService } from '../trainers.service';
import { ProgramService } from '../program.service';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-give-feedback',
  templateUrl: './give-feedback.component.html',
  styleUrls: ['./give-feedback.component.css']
})
export class GiveFeedbackComponent implements OnInit {
  constructor(private router:Router,public stuSer:StuServiceService,public trainerService:TrainersService,public programService:ProgramService,private feedbackService:FeedbackService) { }

  ngOnInit(): void {
    this.feedbackService.getFeedbacks().subscribe(resp=>{
          for(const d of(resp as any)){
            this.feedbackService.feedbacksDb.push({ id: d.id,
             studentId: d.studentId,
             trainerId: d.trainerId,
             programId: d.programId,
             questions:d.questions,
             comments:d.comments,
             suggestions:d.suggestions
            })
          }
         
        })
  }

  feedbackForm=new FormGroup({
    ques1: new FormControl(null,[Validators.min(1),Validators.max(5),Validators.required]),
    ques2: new FormControl(null,[Validators.min(1),Validators.max(5),Validators.required]),
    ques3: new FormControl(null,[Validators.min(1),Validators.max(5),Validators.required]),
    ques4: new FormControl(null,[Validators.min(1),Validators.max(5),Validators.required]),
    ques5: new FormControl(null,[Validators.min(1),Validators.max(5),Validators.required]),
    comments: new FormControl(null,Validators.required),
    suggestions: new FormControl(null,Validators.required)
  });

  submitFeedBack()
  { var feedbackid:string="FDB"+(Number(this.feedbackService.feedbacksDb[this.feedbackService.feedbacksDb.length-1].id.toString().substring(3))+1);
    
    var ques:number[]=[this.feedbackForm.get('ques1').value,
                        this.feedbackForm.get('ques2').value,
                        this.feedbackForm.get('ques3').value,
                        this.feedbackForm.get('ques4').value,
                        this.feedbackForm.get('ques5').value
                      ];
    var comments=this.feedbackForm.get('comments').value;
    var suggestions=this.feedbackForm.get('suggestions').value;
    if(this.feedbackForm.valid)
    {
    var feedback:Feedback=new Feedback(feedbackid,this.stuSer.tempStudent.id,this.trainerService.localTrainer.id,this.programService.localProgram.id,ques,suggestions,comments);
    
    
    this.feedbackService.postFeedback(feedback).subscribe(resp => {
      console.log(resp);
      
    });
    this.router.navigateByUrl('stuActions');

  }
  }

}
