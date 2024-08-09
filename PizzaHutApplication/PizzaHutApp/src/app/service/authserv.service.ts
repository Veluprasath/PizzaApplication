import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthservService {

  constructor(private http: HttpClient) { }

  authappbaseurl = "http://localhost:1212/auth-app"
  authappbaseurl1 = "http://localhost:2424/pizza-app/addUser"

  registerUser(signupdata: any) {
    console.log(signupdata);

    return this.http.post(this.authappbaseurl1, signupdata);
  }


  isLoggedIn: boolean = false;

  loginUser(logindata: any): Observable<any> {
    console.log(logindata)
    this.isLoggedIn = true;
    return this.http.post<any>(this.authappbaseurl + "/login", logindata);
  }

  logout() {
    this.isLoggedIn = false;
  }
}
