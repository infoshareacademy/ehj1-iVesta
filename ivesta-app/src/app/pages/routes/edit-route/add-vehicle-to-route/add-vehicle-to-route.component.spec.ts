import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVehicleToRouteComponent } from './add-vehicle-to-route.component';

describe('AddVehicleToRouteComponent', () => {
  let component: AddVehicleToRouteComponent;
  let fixture: ComponentFixture<AddVehicleToRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddVehicleToRouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddVehicleToRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
