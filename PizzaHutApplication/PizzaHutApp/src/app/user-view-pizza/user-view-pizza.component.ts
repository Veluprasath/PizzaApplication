import { Component, OnInit } from '@angular/core';
import { Pizza, User } from '../class/user';
import { UserPizzaService } from '../service/user-pizza.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-user-view-pizza',
  templateUrl: './user-view-pizza.component.html',
  styleUrls: ['./user-view-pizza.component.css']
})


export class UserViewPizzaComponent implements OnInit {


  UpdateForm = new FormGroup({
    pizzaName: new FormControl('', Validators.required),
    pizzaSize: new FormControl('', Validators.required),
    pizzaPrice: new FormControl('', Validators.required),
    pizzaQuantity: new FormControl('', Validators.required)
  })

  response: any;



  get pizzaName() { return this.UpdateForm.get('pizzaName') }
  get pizzaSize() { return this.UpdateForm.get('pizzaSize') }
  get pizzaPrice() { return this.UpdateForm.get('pizzaPrice') }
  get pizzaQuantity() { return this.UpdateForm.get('pizzaQuantity') }

  listusers!: User[] | undefined;
  segPizza!: Pizza[]

  ngOnInit() {
    this.userService.getOrderedPizza().subscribe(
      (response: any) => {
        this.listusers = response;
        console.log(response);

      })
  }




  constructor(private userService: UserPizzaService, private router: Router) { }


  updateToCart() {
    console.log(this.UpdateForm.value);
    this.userService.updatePizzaToCart(this.UpdateForm.value).subscribe(
      (response: any) => {
        console.log(response);
        alert('Your Order Confirmed!')
        this.router.navigateByUrl("Bill");
        this.total()
      },
      _error => {
        alert(' This type of Content is not exist in database  !')
        this.UpdateForm.reset();
      }
    )

  }


  total() {
    let price: any = this.UpdateForm.value.pizzaPrice
    let quantity: any = this.UpdateForm.value.pizzaQuantity
    let total: any = price * quantity
    alert("Total amount : " + total)
  }


  updatePizzaForEdit(data: any) {
    let fetchuserlist = this.listusers?.find(details => { return details })
    console.log(fetchuserlist)
    this.response = fetchuserlist?.pizzaList
    this.segPizza = this.response
    console.log(this.segPizza)
    let finalct = this.segPizza.find(pname => { return pname.pizzaName == data })
    console.log(finalct)
    let getName: any = finalct?.pizzaName
    let getSize: any = finalct?.pizzaSize
    let getPrice: any = finalct?.pizzaPrice
    let getQuantity: any = finalct?.pizzaQuantity

    this.UpdateForm.setValue({

      pizzaName: getName,
      pizzaSize: getSize,
      pizzaPrice: getPrice,
      pizzaQuantity: getQuantity
    })
  }




  deleteCart(pizzaName: string | undefined) {
    this.userService.deletePizzaToCart(pizzaName).subscribe();
  }
}
