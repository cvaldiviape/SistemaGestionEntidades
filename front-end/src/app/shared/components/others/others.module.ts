import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuIconComponent } from './menu-icon/menu-icon.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';

@NgModule({
  declarations: [
    MenuIconComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatIconModule, 
    MatMenuModule,
  ],
  exports: [
    MenuIconComponent,
  ]
})
export class OthersModule { }
