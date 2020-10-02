import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherAgenciesComponent } from './other-agencies.component';

describe('OtherAgenciesComponent', () => {
  let component: OtherAgenciesComponent;
  let fixture: ComponentFixture<OtherAgenciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherAgenciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherAgenciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
