import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDriverToRouteComponent } from './add-driver-to-route.component';

describe('AddDriverToRouteComponent', () => {
  let component: AddDriverToRouteComponent;
  let fixture: ComponentFixture<AddDriverToRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDriverToRouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDriverToRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
