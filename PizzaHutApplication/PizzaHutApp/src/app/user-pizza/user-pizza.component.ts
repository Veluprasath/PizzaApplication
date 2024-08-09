import { Component, OnInit } from '@angular/core';
import { AdminservService } from '../service/adminserv.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserPizzaService } from '../service/user-pizza.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-pizza',
  templateUrl: './user-pizza.component.html',
  styleUrls: ['./user-pizza.component.css']
})
export class UserPizzaComponent implements OnInit {
  pizzaData: any;


  constructor(private adminService: AdminservService, private userService: UserPizzaService, private router: Router) { }
  ngOnInit() {
    this.getAllItem()
  }


  getAllItem() {
    this.adminService.getAllItem().subscribe(

      (response: any) => {
        this.pizzaData = response;
        console.log(response);

      })
  }


  AddCartForm = new FormGroup({
    pizzaId: new FormControl('', Validators.required),
    pizzaName: new FormControl('', Validators.required),
    pizzaSize: new FormControl('', Validators.required),
    pizzaPrice: new FormControl('', Validators.required),
    pizzaQuantity: new FormControl('', Validators.required)
  })



  get pizzaId() { return this.AddCartForm.get('pizzaId') }
  get pizzaName() { return this.AddCartForm.get('pizzaName') }
  get pizzaSize() { return this.AddCartForm.get('pizzaSize') }
  get pizzaPrice() { return this.AddCartForm.get('pizzaPrice') }
  get pizzaQuantity() { return this.AddCartForm.get('pizzaQuantity') }


  AddToCart() {
    this.userService.addPizzaToCart(this.AddCartForm.value).subscribe(
      response => {
        console.log(response);
        alert("Add Cart Successfully")
        this.router.navigateByUrl("ViewCart")
      })

  }

  getPizzaForEdit(pizza: any) {
    this.AddCartForm.setValue(pizza)
  }


}