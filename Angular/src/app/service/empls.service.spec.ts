import { TestBed } from '@angular/core/testing';

import { EmplsService } from './empls.service';

describe('EmplsService', () => {
  let service: EmplsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmplsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
