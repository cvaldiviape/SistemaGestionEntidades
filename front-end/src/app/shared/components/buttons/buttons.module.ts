import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BtnCustomAComponent } from './btn-custom-a/btn-custom-a.component';
import { BtnCustomBComponent } from './btn-custom-b/btn-custom-b.component';

@NgModule({
  declarations: [
    BtnCustomAComponent,
    BtnCustomBComponent,
  ],
  imports: [
    CommonModule
  ],
  exports: [
    BtnCustomAComponent,
    BtnCustomBComponent,
  ]
})
export class ButtonsModule { }
