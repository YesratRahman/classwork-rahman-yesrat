import { Component, OnInit } from '@angular/core';
import { RegisterUserRequest } from 'src/app/interfaces/RegisterUserRequest';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  userName : string = ""; 
  userPassword : string = ""; 
  userEmail : string = ""; 
  confirmUserPassword: string = ""; 
  date : Date | undefined;
  constructor(private authService : AuthService) { }

  ngOnInit(): void {
  }
  submit(){
    let toAdd: RegisterUserRequest = {
      Username: this.userName,
      Email: this.userEmail,
      Password: this.userPassword,
      date: new Date()

    };


    this.authService.registerUser(toAdd).subscribe((_) => console.log(_));
  }

}
