import { Component, OnInit } from '@angular/core';
import { AuthservService } from '../service/authserv.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(public authService: AuthservService, private router: Router) { }

  isLoggedIn: any = true;

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isLoggedIn
  }

  logoutUser() {
    this.authService.logout();
    this.isLoggedIn = true;
    this.router.navigateByUrl("Home")
  }
}
