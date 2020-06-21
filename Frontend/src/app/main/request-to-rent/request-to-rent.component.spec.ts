import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestToRentComponent } from './request-to-rent.component';

describe('RequestToRentComponent', () => {
  let component: RequestToRentComponent;
  let fixture: ComponentFixture<RequestToRentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestToRentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestToRentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
