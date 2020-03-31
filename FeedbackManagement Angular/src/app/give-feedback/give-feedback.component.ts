import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { Trainer } from '../Trainer';
import { Program } from '../Program';
import { StuServiceService } from '../stu-service.service';

@Component({
  selector: 'app-give-feedback',
  templateUrl: './give-feedback.component.html',
  styleUrls: ['./give-feedback.component.css']
})
export class GiveFeedbackComponent implements OnInit {
  student:Student;
  trainer:Trainer;
  program:Program;

  constructor(private stuSer:StuServiceService) { }

  ngOnInit(): void {
    this.student=this.stuSer.tempStudent;
  }

}
