import { TestBed } from '@angular/core/testing';

import { AdminLoadGuard } from './admin-load.guard';

describe('AdminLoadGuard', () => {
  let guard: AdminLoadGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AdminLoadGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
