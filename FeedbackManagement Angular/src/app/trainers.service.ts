import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Trainer } from './Trainer';
import { timingSafeEqual } from 'crypto';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class TrainersService {
  public trainerDB:any[]=[];
  localTrainer:Trainer;

  constructor(private http:HttpClient,private feed:FeedbackService) { }

  loadTrainers()
  {
    return this.http.get<Trainer[]>('http://localhost:3000/trainers').subscribe(resp=>{
      for(const d of(resp as any)){
        this.trainerDB.push({ id: d.id,
          trainerName:d.trainerName,
          trainerEmail:d.trainerEmail,
          password:d.password,
          active:d.active,
          skills:d.skills
        })
      }
     console.log(this.trainerDB);
     
     
    });;
  }

  addTrainer(trainer:Trainer)
  {
    return this.http.post('http://localhost:3000/trainers',trainer);
  }
  
  deleteTrainer(trainerId:any)
  {
    return this.http.delete('http://localhost:3000/trainers/'+trainerId);
  }
  updateTrainer(trainerId:any,trainer:Trainer)
  {
    return this.http.put('http://localhost:3000/trainers/'+trainerId,trainer);
  }

  viewFeedbacks()
  {let feedbacks:Feedback[]=[];
    this.feed.getFeedbacks().subscribe(resp=>{
      for(const d of(resp as any)){

        if(this.localTrainer.id==d.trainerId)
        {
          feedbacks.push(d);
        }
      }

    })
    return feedbacks;
  }

  viewFeedbacksbyProgram(programId:any)
  {
    let feedbacks:Feedback[]=[];
    this.feed.getFeedbacks().subscribe(resp=>{
      for(const d of(resp as any)){

        if(programId==d.programId)
        {
          feedbacks.push(d);
        }
      }
      return feedbacks;
    })
    
  }

  getPrograms()
  {let programs:any[]=[];
    this.http.get('http://localhost:3000/trainersProgram').subscribe(resp=>{
      for(const d of(resp as any))
      {
        if(d.trainerId==this.localTrainer.id)
        {
          programs.push(d.programId);
        }
      }
    }

    )
    return programs;
  }

  addskills(skill:any)
  { if(!this.localTrainer.skills.includes(skill))
      this.localTrainer.skills.push(skill);   
  }

  viewFeedBackDefaulters(programId:any){
    let studentsInProgram:any[];
    let courseId:any;
    

  }

}
