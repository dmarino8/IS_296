import { Component, OnInit } from '@angular/core';
import { ICustomerReview } from '../customerReview';
import { CustomerreviewsService } from '../customerreviews.service'
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  summary = "Product summary!";
  reviews: ICustomerReview[] = [];

  constructor(private _customerReviewsService: CustomerreviewsService) { }

  ngOnInit(): void {
    this._customerReviewsService.getCustomerReviews()
    .subscribe(data => this.reviews = data);
  }

  getProductSummary() {
    return this.summary;
  }

}
