import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QualifiedUsersComponent } from './qualified-users.component';

describe('QualifiedUsersComponent', () => {
  let component: QualifiedUsersComponent;
  let fixture: ComponentFixture<QualifiedUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QualifiedUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QualifiedUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
