import { TestBed } from '@angular/core/testing';

import { DriversHttpService } from './drivers-http.service';

describe('DriversHttpService', () => {
  let service: DriversHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DriversHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
