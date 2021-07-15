import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/interfaces/LoginRequest';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  username : string = "";
  password : string = "";

  constructor(private authService : AuthService, private router : Router) { }

  ngOnInit(): void {
  }

  submit() {
    let toLogin : LoginRequest = {
      Username : this.username,
      Password : this.password,
    }

    this.authService.loginUser(toLogin);
    this.router.navigate([""]);
    console.log(toLogin);
  }


}
