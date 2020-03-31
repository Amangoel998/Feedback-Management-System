import { TestBed } from '@angular/core/testing';

import { StuServiceService } from './stu-service.service';

describe('StuServiceService', () => {
  let service: StuServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StuServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
