import { Component } from '@angular/core';
import { AuthservService } from '../service/authserv.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  ngOnInit() {
  }

  constructor(private authService: AuthservService, private router: Router) { }


  loginForm = new FormGroup({
    emailId: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

  get emailId() { return this.loginForm.get('emailId') }
  get password() { return this.loginForm.get('password') }

  res: any;


  loginUser() {
    console.log(this.loginForm.value);
    this.authService.loginUser(this.loginForm.value).subscribe(
      (response: any) => {

        this.res = response;

        console.log(this.res.token);
        console.log(this.res.emailId);

        localStorage.setItem('jwt', this.res.token);
        localStorage.setItem('emailId', this.res.emailId);

        this.loginForm.reset();


        if (this.res.role == "User") {
          alert("User LoggedIn Successfully")
          this.router.navigateByUrl("User");
        }
        else if (this.res.role == "Admin") {
          alert("Admin LoggedIn Successfully")
          this.router.navigateByUrl("Admin");
        }


      },
      _error => {
        alert('Invalid Credentials,Enter the valid Credentials !')
        this.loginForm.reset();
      }
    )
  }
}
