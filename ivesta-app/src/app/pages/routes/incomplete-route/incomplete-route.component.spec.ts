import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncompleteRouteComponent } from './incomplete-route.component';

describe('IncompleteRouteComponent', () => {
  let component: IncompleteRouteComponent;
  let fixture: ComponentFixture<IncompleteRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncompleteRouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncompleteRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
