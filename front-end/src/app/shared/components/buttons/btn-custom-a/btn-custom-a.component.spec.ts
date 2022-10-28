import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BtnCustomAComponent } from './btn-custom-a.component';

describe('BtnCustomAComponent', () => {
  let component: BtnCustomAComponent;
  let fixture: ComponentFixture<BtnCustomAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BtnCustomAComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BtnCustomAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
