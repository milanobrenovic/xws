import { TestBed } from '@angular/core/testing';

import { QualifiedUsersService } from './qualified-users.service';

describe('MessagesService', () => {
  let service: QualifiedUsersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QualifiedUsersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});