import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthservService } from '../service/authserv.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  ngOnInit() {
  }
  constructor(private authService: AuthservService, private router: Router) { }

  signupForm = new FormGroup({
    userName: new FormControl('', Validators.required),
    emailId: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    contactNumber: new FormControl('', Validators.required),
  })

  get userName() { return this.signupForm.get('userName') }
  get emailId() { return this.signupForm.get('emailId') }
  get password() { return this.signupForm.get('password') }
  get address() { return this.signupForm.get('address') }
  get contactNumber() { return this.signupForm.get('contactNumber') }



  addUserData() {
    console.log(this.signupForm.value)
    this.authService.registerUser(this.signupForm.value).subscribe(
      (response: any) => {
        console.log(response);
        alert('Welcome New user !')
        this.signupForm.reset();
        this.router.navigate(['LogIn'])
      },
      (
        _error: any) => {
        alert('EmailId is Already Exist !')
        this.signupForm.reset();
      }
    )
  }

}
