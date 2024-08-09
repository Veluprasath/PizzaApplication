import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { UserPizzaService } from '../service/user-pizza.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  ngOnInit() {
    this.userService.getOrderedPizza().subscribe(
      (response: any) => {
        this.listusers = response;
        console.log(response);

      })
  }

  constructor(private userService: UserPizzaService) { }
  pizzaData: any
  listusers: User[] | undefined



  calculateTotalCost(pizzaData: any) {
    return pizzaData.pizzaQuantity * pizzaData.pizzaPrice;

  }
}

