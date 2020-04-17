import { Component, OnInit } from '@angular/core';
import { StuServiceService } from './stu-service.service';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 
  title = 'FeedbackManagement';
  feedbacks:any[]=[];
  spresp:any;

  flag:boolean;
  constructor(private stuSer:StuServiceService,private feed:FeedbackService){
    
  }

  ngOnInit(): void {
    this.flag=this.stuSer.flag;
    
    

    
  }

  // Refrence for get and Post

//   addFeedBack(feed:Feedback){
//     this.feed.postFeedback(feed).subscribe(resp => {
//       return this.spresp.push(resp);
//     });
//   }
// getFeedbacks()
// {
//   this.feed.getFeedbacks().subscribe(resp=>{
//     for(const d of(resp as any)){
//       this.feedbacks.push({ id: d.id,
//        studentId: d.studentId,
//        trainerId: d.trainerId,
//        programId: d.programId,
//        questions:d.questions,
//        comments:d.comments,
//        suggestions:d.suggestions
//       })
//     }
//    console.log(this.feedbacks);
   
//   })
// }

// deleteFeedback(id:any)
// {
//   this.feed.deleteFeedback(id).subscribe(resp => {
//     return this.spresp.push(resp);
//   });
  
// }

// updateFeedback(id:any,feed:Feedback)
// { 
//   this.feed.updateFeedback(id,feed).subscribe(resp => {
//     return this.spresp.push(resp);
//   });
// }


}
