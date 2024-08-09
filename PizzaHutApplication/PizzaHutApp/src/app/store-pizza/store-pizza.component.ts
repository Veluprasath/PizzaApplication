import { Component, OnInit } from '@angular/core';
import { AdminservService } from '../service/adminserv.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-store-pizza',
  templateUrl: './store-pizza.component.html',
  styleUrls: ['./store-pizza.component.css']
})
export class StorePizzaComponent implements OnInit {
  ngOnInit() {
  }
  constructor(private adminService: AdminservService, private router: Router) { }

  AddForm = new FormGroup({
    pizzaName: new FormControl('', Validators.required),
    pizzaSize: new FormControl('', Validators.required),
    pizzaPrice: new FormControl('', Validators.required),
    pizzaQuantity: new FormControl('', Validators.required)
  })

  get pizzaName() { return this.AddForm.get('pizzaName') }
  get pizzaSize() { return this.AddForm.get('pizzaSize') }
  get pizzaPrice() { return this.AddForm.get('pizzaPrice') }
  get pizzaQuantity() { return this.AddForm.get('pizzaQuantity') }

  addPizza() {
    console.log(this.AddForm.value)
    this.adminService.addItem(this.AddForm.value).subscribe(
      (response: any) => {
        console.log(response);
        alert('Pizza Added Successfully !')
        this.AddForm.reset();
        this.router.navigate(['ViewPizza'])
      }
    )
  }
}
