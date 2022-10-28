import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BtnCustomBComponent } from './btn-custom-b.component';

describe('BtnCustomBComponent', () => {
  let component: BtnCustomBComponent;
  let fixture: ComponentFixture<BtnCustomBComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BtnCustomBComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BtnCustomBComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
