import { Component, OnInit } from '@angular/core';
import { AdminservService } from '../service/adminserv.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-view-pizza',
  templateUrl: './view-pizza.component.html',
  styleUrls: ['./view-pizza.component.css']
})
export class ViewPizzaComponent implements OnInit {
  pizzaData: any;
  ngOnInit() {
  }


  constructor(private adminService: AdminservService) {
    this.getAllItem()
  }
  UpdateForm = new FormGroup({
    pizzaId: new FormControl('', Validators.required),
    pizzaName: new FormControl('', Validators.required),
    pizzaSize: new FormControl('', Validators.required),
    pizzaPrice: new FormControl('', Validators.required),
    pizzaQuantity: new FormControl('', Validators.required)
  })



  get pizzaId() { return this.UpdateForm.get('pizzaId') }
  get pizzaName() { return this.UpdateForm.get('pizzaName') }
  get pizzaSize() { return this.UpdateForm.get('pizzaSize') }
  get pizzaPrice() { return this.UpdateForm.get('pizzaPrice') }
  get pizzaQuantity() { return this.UpdateForm.get('pizzaQuantity') }



  getAllItem() {
    this.adminService.getAllItem().subscribe(

      (response: any) => {
        this.pizzaData = response;
        console.log(response);

      })
  }



  updatePizza() {
    console.log(this.UpdateForm.value);
    this.adminService.updateAllItem(this.UpdateForm.value.pizzaId, this.UpdateForm.value).subscribe(
      (response: any) => {
        this.pizzaData = response;
        console.log(response);
        alert("Updated successfully")
        this.UpdateForm.reset;
      })
  }
  getPizzaForEdit(pizza: any) {
    this.UpdateForm.setValue(pizza)
  }

  deleteItem(pizzaId: string) {
    if (confirm("Are You Sure To Delete")) {
      this.adminService.deleteItem(pizzaId).subscribe(
        (response: any) => {
          console.log(response);
          alert("Deleted Successfully")
          this.getAllItem()
        })
    }
  }

}
