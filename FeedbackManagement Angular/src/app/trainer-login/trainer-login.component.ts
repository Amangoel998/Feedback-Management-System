import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TrainersService } from '../trainers.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainer-login',
  templateUrl: './trainer-login.component.html',
  styleUrls: ['./trainer-login.component.css']
})
export class TrainerLoginComponent implements OnInit {

  constructor(private trainerService:TrainersService,private router:Router) { }

  ngOnInit(): void {
    this.trainerService.loadTrainers();
  }
  trainerForm=new FormGroup({
    trainerEmail: new FormControl('', [Validators.email]),
    pass: new FormControl('')
  });



  login() {
  
    let email = this.trainerForm.get('trainerEmail').value;
    let pass = this.trainerForm.get('pass').value;
    
    
    
    for(let i=0;i<this.trainerService.trainerDB.length;i++) {
      

      if (this.trainerService.trainerDB[i].trainerEmail == email&&this.trainerService.trainerDB[i].password==pass){     
        this.trainerService.localTrainer=this.trainerService.trainerDB[i];
        this.trainerService.flag=true;
        break;
      }
          
    }
    if (this.trainerService.flag) {
      this.router.navigateByUrl("/trainerHome");
      
    }

  }

  
}
