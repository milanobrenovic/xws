import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransporationVehicleListComponent } from './transporation-vehicle-list.component';

describe('TransporationVehicleListComponent', () => {
  let component: TransporationVehicleListComponent;
  let fixture: ComponentFixture<TransporationVehicleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransporationVehicleListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransporationVehicleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
