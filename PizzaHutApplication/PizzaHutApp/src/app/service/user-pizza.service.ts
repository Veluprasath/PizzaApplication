import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserPizzaService {
  constructor(private http: HttpClient) { }

  pizzaAppBaseUrl = "http://localhost:2424/pizza-app"
  pizzaAppBaseUrl1 = "http://localhost:2424/pizza-app/addToCart/"
  pizzaAppBaseUrl2 = "http://localhost:2424/pizza-app/updateToCart/"
  pizzaAppBaseUrl3 = "http://localhost:2424/pizza-app/deleteToCart/"
  pizzaAppBaseUrl4 = "http://localhost:2424/pizza-app/fetchUser/"

  addPizzaToCart(data: any) {
    let httpheader = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`
    });
    let Options = { headers: httpheader }
    return this.http.post(this.pizzaAppBaseUrl1 + localStorage.getItem('emailId'), data, Options);
  }

  getOrderedPizza(): Observable<any> {
    console.log(localStorage.getItem('jwt'))
    console.log(localStorage.getItem('emailId'))
    let httpheader = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`
    });
    let Options = { headers: httpheader }
    return this.http.get(this.pizzaAppBaseUrl4 + localStorage.getItem('emailId'), Options)
  }

  updatePizzaToCart(data: any): Observable<any> {
    console.log(localStorage.getItem('jwt'))
    console.log(localStorage.getItem('emailId'))
    let httpheader = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`
    });
    let Options = { headers: httpheader }
    return this.http.put(this.pizzaAppBaseUrl2 + localStorage.getItem('emailId'), data, Options)
  }

  deletePizzaToCart(data: any) {
    let httpheader = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`
    });
    let Options = { headers: httpheader }
    return this.http.delete(this.pizzaAppBaseUrl3 + localStorage.getItem('emailId') + "/" + `${data}`, Options)
  }

}
