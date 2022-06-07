import { TestBed } from '@angular/core/testing';

import { VehicleHttpService } from './vehicle-http.service';

describe('VehicleHttpService', () => {
  let service: VehicleHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
