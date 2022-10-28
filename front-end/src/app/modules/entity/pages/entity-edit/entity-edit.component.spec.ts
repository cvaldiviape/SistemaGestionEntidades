import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntityEditComponent } from './entity-edit.component';

describe('EntityEditComponent', () => {
  let component: EntityEditComponent;
  let fixture: ComponentFixture<EntityEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntityEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntityEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
