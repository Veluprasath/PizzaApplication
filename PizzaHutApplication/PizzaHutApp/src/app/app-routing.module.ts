import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { StorePizzaComponent } from './store-pizza/store-pizza.component';
import { ViewPizzaComponent } from './view-pizza/view-pizza.component';
import { HomeComponent } from './home/home.component';
import { UserPizzaComponent } from './user-pizza/user-pizza.component';
import { UserViewPizzaComponent } from './user-view-pizza/user-view-pizza.component';
import { BillComponent } from './bill/bill.component';
import { LoginGuardGuard } from './loginguard.guard';


const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "Home", component: HomeComponent },
  { path: "LogIn", component: LoginComponent },
  { path: "SignUp", component: SignUpComponent },
  { path: "Admin", component: AdminComponent },
  { path: "User", component: UserComponent, canActivate: [LoginGuardGuard] },
  { path: "StorePizza", component: StorePizzaComponent },
  { path: "ViewPizza", component: ViewPizzaComponent },
  { path: "AddToCart", component: UserPizzaComponent, canActivate: [LoginGuardGuard] },
  { path: "ViewCart", component: UserViewPizzaComponent, canActivate: [LoginGuardGuard] },
  { path: "Bill", component: BillComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
