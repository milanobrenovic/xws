import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNewAdComponent } from './create-new-ad.component';

describe('CreateNewAdComponent', () => {
  let component: CreateNewAdComponent;
  let fixture: ComponentFixture<CreateNewAdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateNewAdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewAdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
