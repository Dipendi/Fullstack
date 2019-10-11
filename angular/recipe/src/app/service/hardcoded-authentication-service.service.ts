import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationServiceService {

  constructor() { }

  authenticate(username, password){
    if(username==="Dipendi" && password==='Dipendi') {
      sessionStorage.setItem('authenticaterUser', username);
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticaterUser')
    return !(user === null)
  }

  logout(){
    sessionStorage.removeItem('authenticaterUser')
  }
}
