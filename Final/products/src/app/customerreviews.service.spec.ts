import { TestBed } from '@angular/core/testing';

import { CustomerreviewsService } from './customerreviews.service';

describe('CustomerreviewsService', () => {
  let service: CustomerreviewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerreviewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
