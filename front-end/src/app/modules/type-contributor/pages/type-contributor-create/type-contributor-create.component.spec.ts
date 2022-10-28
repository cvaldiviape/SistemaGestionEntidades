import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeContributorCreateComponent } from './type-contributor-create.component';

describe('TypeContributorCreateComponent', () => {
  let component: TypeContributorCreateComponent;
  let fixture: ComponentFixture<TypeContributorCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeContributorCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeContributorCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
