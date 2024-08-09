import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminservService {

  pizzaAppBaseUrl = "http://localhost:3636/pizza-product-app"

  constructor(private http: HttpClient) { }


  addItem(pizzaData: any) {
    return this.http.post(this.pizzaAppBaseUrl + "/addPizza", pizzaData);
  }



  getAllItem() {
    return this.http.get(this.pizzaAppBaseUrl + "/fetchAllPizza");
  }


  deleteItem(pizzaId: String) {
    return this.http.delete(this.pizzaAppBaseUrl + "/deletePizza/" + pizzaId);
  }


  updateAllItem(pizzaId: any, data: any) {
    return this.http.put(this.pizzaAppBaseUrl + "/updatePizza/" + pizzaId, data);
  }
}
