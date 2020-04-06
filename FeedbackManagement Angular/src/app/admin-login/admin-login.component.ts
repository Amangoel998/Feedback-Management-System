import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  adminEmail:string="admin@Test.com";
  adminPass:string="admin123";
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

 adminForm= new FormGroup({
    adminEmail: new FormControl('', [Validators.email]),
    pass: new FormControl('')
  });

  login()
  {
    var email=this.adminForm.get('adminEmail').value;
    var pass=this.adminForm.get('pass').value;

    if(email==this.adminEmail&&pass==this.adminPass)
    {
      this.router.navigateByUrl('adminHome');
    }
    
  }

}
