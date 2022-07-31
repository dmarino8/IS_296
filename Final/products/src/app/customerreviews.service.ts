import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICustomerReview } from './customerReview';

@Injectable({
  providedIn: 'root'
})
export class CustomerreviewsService {
  private _url: string = "http://localhost:8090/api/reviews";

  constructor(private http: HttpClient) { }

  getCustomerReviews() {
    return this.http.get<ICustomerReview[]>(this._url);
  }
}
