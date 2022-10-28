import { TestBed } from '@angular/core/testing';

import { TypeContributorService } from './type-contributor.service';

describe('TypeContributorService', () => {
  let service: TypeContributorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeContributorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
