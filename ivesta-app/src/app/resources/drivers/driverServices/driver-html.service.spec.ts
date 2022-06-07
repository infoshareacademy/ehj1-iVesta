import { TestBed } from '@angular/core/testing';

import { DriverHtmlService } from './driver-html.service';

describe('DriverHtmlService', () => {
  let service: DriverHtmlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DriverHtmlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
