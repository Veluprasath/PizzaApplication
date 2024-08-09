import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { StorePizzaComponent } from './store-pizza/store-pizza.component';
import { ViewPizzaComponent } from './view-pizza/view-pizza.component';
import { HomeComponent } from './home/home.component';
import { UserPizzaComponent } from './user-pizza/user-pizza.component';
import { UserViewPizzaComponent } from './user-view-pizza/user-view-pizza.component';
import { BillComponent } from './bill/bill.component';
import { LoginGuardGuard } from './loginguard.guard';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    NavBarComponent,
    UserComponent,
    AdminComponent,
    StorePizzaComponent,
    ViewPizzaComponent,
    HomeComponent,
    UserPizzaComponent,
    UserViewPizzaComponent,
    BillComponent,
  ],




  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule, FormsModule,
    MatFormFieldModule, MatSelectModule,
    MatInputModule, MatCardModule, MatIconModule,
    MatButtonModule, MatGridListModule, HttpClientModule

  ],


  
  providers: [LoginGuardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
