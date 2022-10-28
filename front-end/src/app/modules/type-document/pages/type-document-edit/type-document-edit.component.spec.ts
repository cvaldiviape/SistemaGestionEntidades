import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeDocumentEditComponent } from './type-document-edit.component';

describe('TypeDocumentEditComponent', () => {
  let component: TypeDocumentEditComponent;
  let fixture: ComponentFixture<TypeDocumentEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeDocumentEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeDocumentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
