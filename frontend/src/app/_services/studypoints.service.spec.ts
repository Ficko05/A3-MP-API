import { TestBed } from '@angular/core/testing';

import { StudypointsService } from './studypoints.service';

describe('StudypointsService', () => {
  let service: StudypointsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudypointsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
