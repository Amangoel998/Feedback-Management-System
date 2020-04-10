import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Trainer } from './Trainer';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';
import { StuServiceService } from './stu-service.service';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class TrainersService {
  public trainerDB:any[]=[];
  localTrainer:Trainer;
  public flag:boolean=false;

  constructor(private http:HttpClient,private feed:FeedbackService,private stuServ:StuServiceService) { }

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
  { this.trainerDB.push(trainer);
    return this.http.post('http://localhost:3000/trainers',trainer);
  }
  
  deleteTrainer(trainerId:any)
  { for(var i=0;i<this.trainerDB.length;i++)
    {
      if(this.trainerDB[i].id==trainerId)
      {
        this.trainerDB.splice(i,1);
      }
    }
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

        if(programId==d.programId&&this.localTrainer.id==d.trainerId)
        {
          feedbacks.push(d);
        }
      }
      
      
    })
    return feedbacks;
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

  getProgramsAndBatch()
  {let programs:any[]=[];
    this.http.get('http://localhost:3000/trainersProgram').subscribe(resp=>{
      for(const d of(resp as any))
      {
        if(d.trainerId==this.localTrainer.id)
        {
          programs.push(d);
        }
      }
    }

    )
    return programs;
  }

  addskills(skill:any)
  { if(!this.localTrainer.skills.includes(skill))
      {this.localTrainer.skills.push(skill);  
      this.updateTrainer(this.localTrainer.id,this.localTrainer).subscribe() ;
      }
  }

  deleteSkills(skill:any)
  {
    
      for(let i=0;i<this.localTrainer.skills.length;i++)
      {
        if(this.localTrainer.skills[i]===skill)
        {
          this.localTrainer.skills.splice(i,1);
         
        }
      }
      this.updateTrainer(this.localTrainer.id,this.localTrainer).subscribe() ;
    
  }

  getSkills(){
    return this.localTrainer.skills;
  }

  viewFeedBackDefaulters(programId:any,batch:any){
    let studentsInProgram=this.stuServ.getStudentsFromBatch(batch);

    this.feed.getFeedbacks().subscribe(resp=>{
      for(const d of (resp as any))
      {
          if(d.programId==programId){
            for(let i=0;i<studentsInProgram.length;i++)
            {
              if(studentsInProgram[i].id==d.studentId)
            
                studentsInProgram.splice(i,1);
              }
            }

          }
    })
    console.log(studentsInProgram);
    
    return studentsInProgram;


    

  }
  setLocalTrainerById(trainerId){
   this.http.get<Trainer>('http://localhost:3000/trainers/'+trainerId).subscribe((data:Trainer)=>{
     this.localTrainer=data;
   });

  }

  getTrainerByProgram(programId,batch)
  {
    this.http.get('http://localhost:3000/trainersProgram').subscribe(resp=>{
      for(const d of(resp as any))
      {
        if(d.programId==programId&&d.batch==batch)
        {
          this.setLocalTrainerById(d.trainerId);
          
        }
      }
      
  });
}
}
