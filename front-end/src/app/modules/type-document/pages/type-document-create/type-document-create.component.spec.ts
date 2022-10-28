import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeDocumentCreateComponent } from './type-document-create.component';

describe('TypeDocumentCreateComponent', () => {
  let component: TypeDocumentCreateComponent;
  let fixture: ComponentFixture<TypeDocumentCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeDocumentCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeDocumentCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
