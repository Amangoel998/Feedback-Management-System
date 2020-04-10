import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Feedback } from './feedback';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  feedbacksDb:any[]=[];

  constructor(private http:HttpClient) { }

  getFeedbacks():Observable<Feedback[]>{
  return this.http.get<Feedback[]>('http://localhost:3000/feedbacks');
   
  }

  postFeedback(feedback:Feedback)
  {
    return this.http.post('http://localhost:3000/feedbacks',feedback);
  }

  deleteFeedback(id:any)
  {
    return this.http.delete('http://localhost:3000/feedbacks/'+id);
  }

  updateFeedback(id:any,feedback:Feedback)
  {
    return this.http.put('http://localhost:3000/feedbacks/'+id,feedback);
  }
}
