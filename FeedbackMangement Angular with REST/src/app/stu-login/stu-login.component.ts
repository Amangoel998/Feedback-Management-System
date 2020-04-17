import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Student } from '../student';
import { Router } from '@angular/router';
import { StuServiceService } from '../stu-service.service';

@Component({
  selector: 'app-stu-login',
  templateUrl: './stu-login.component.html',
  styleUrls: ['./stu-login.component.css']
})
export class StuLoginComponent implements OnInit {
  
  

  constructor(private stuSer:StuServiceService,private router:Router) { }


  loginStu = new FormGroup({
    stuEmail: new FormControl('', [Validators.email]),
    pass: new FormControl('')
  });

  


  ngOnInit(): void {
    
    this.stuSer.getStudents();
    
    
    
  }


  login() {
  
    let email = this.loginStu.get('stuEmail').value;
    let pass = this.loginStu.get('pass').value;
    
    
    
    for(let i=0;i<this.stuSer.studentDb.length;i++) {
      

      if (this.stuSer.studentDb[i].studentEmail == email&&this.stuSer.studentDb[i].password==pass){     
        this.stuSer.tempStudent=this.stuSer.studentDb[i];
        this.stuSer.flag=true;
        break;
      }
          
    }
    if (this.stuSer.flag) {
      this.router.navigateByUrl("/stuActions");
      
    }

  }



}
