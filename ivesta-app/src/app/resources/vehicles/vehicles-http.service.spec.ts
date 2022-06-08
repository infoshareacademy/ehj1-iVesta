import { TestBed } from '@angular/core/testing';

import { VehiclesHttpService } from './vehicles-http.service';

describe('VehiclesHttpService', () => {
  let service: VehiclesHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiclesHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
