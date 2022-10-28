import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { ButtonsModule } from '../../shared/components/buttons/buttons.module';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { QRCodeModule } from 'angularx-qrcode';
import { RegisterComponent } from './pages/register/register.component';

@NgModule({
  declarations: [
    SignInComponent,
    RegisterComponent,
  ],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    ButtonsModule,
    FormsModule,
    ReactiveFormsModule,
    // material
    MatFormFieldModule, 
    MatInputModule, 
    MatIconModule, 
    MatButtonModule,
    MatNativeDateModule,
    MatSelectModule,
    QRCodeModule
  ],
})
export class AuthenticationModule { }