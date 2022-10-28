import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './auth-layout/auth-layout.component';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { DashboardModule } from '../dashboard/dashboard.module';

@NgModule({
  declarations: [
    AdminLayoutComponent,
    AuthLayoutComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule,
    FormsModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    DashboardModule,
  ]
})
export class LayoutsModule { }
