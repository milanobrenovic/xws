import { TestBed } from '@angular/core/testing';

import { RequestToRentService } from './request-to-rent.service';

describe('RequestToRentService', () => {
  let service: RequestToRentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequestToRentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
