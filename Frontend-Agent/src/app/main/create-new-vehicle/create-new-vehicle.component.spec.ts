import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNewVehicleComponent } from './create-new-vehicle.component';

describe('CreateNewVehicleComponent', () => {
  let component: CreateNewVehicleComponent;
  let fixture: ComponentFixture<CreateNewVehicleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateNewVehicleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
