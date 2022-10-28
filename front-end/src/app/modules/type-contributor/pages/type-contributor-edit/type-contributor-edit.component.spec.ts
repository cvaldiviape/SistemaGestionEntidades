import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeContributorEditComponent } from './type-contributor-edit.component';

describe('TypeContributorEditComponent', () => {
  let component: TypeContributorEditComponent;
  let fixture: ComponentFixture<TypeContributorEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeContributorEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeContributorEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
