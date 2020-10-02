import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTransportationVehicleComponent } from './create-transportation-vehicle.component';

describe('CreateTransportationVehicleComponent', () => {
  let component: CreateTransportationVehicleComponent;
  let fixture: ComponentFixture<CreateTransportationVehicleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateTransportationVehicleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTransportationVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
