import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { HardcodedAuthenticationServiceService } from '../service/hardcoded-authentication-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false
  errorMessage = 'Invalid Credentials'

  // Router
  // Dependency Injection for using router 
  constructor(private router: Router, 
      private hardcodedAuthenticationServiceService: HardcodedAuthenticationServiceService) { }

  ngOnInit() {
  }

  handleLogin() {

    //if(this.username==='Dipendi' && this.password==='Dipendi') {
      if(this.hardcodedAuthenticationServiceService.authenticate(this.username, this.password)) {
      //Redirect to welcome page on successful login
      this.router.navigate(['welcome'])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
    
    console.log(this.username);
  }
}
