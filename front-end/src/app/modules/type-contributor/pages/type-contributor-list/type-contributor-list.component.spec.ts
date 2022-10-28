import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeContributorListComponent } from './type-contributor-list.component';

describe('TypeContributorListComponent', () => {
  let component: TypeContributorListComponent;
  let fixture: ComponentFixture<TypeContributorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeContributorListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeContributorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
