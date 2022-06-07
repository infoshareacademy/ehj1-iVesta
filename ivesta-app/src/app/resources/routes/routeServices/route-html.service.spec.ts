import { TestBed } from '@angular/core/testing';

import {RouteHtmlService} from './route-html.service';

describe('RouteHtmlService', () => {
  let service: RouteHtmlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteHtmlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
