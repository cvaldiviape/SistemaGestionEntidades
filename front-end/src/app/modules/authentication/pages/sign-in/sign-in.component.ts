import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from '../../../../security/services/jwt.service';
import { AuthRequestDTO } from '../../../../models/request/auth-request-dto';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  public title: String;
  public subtitle: String;
  public hide: boolean; /* password */
  public loading: boolean;
  public formReactive: FormGroup;
  public qrCode: string | undefined;

  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _authService: AuthService,
    private _jwtService: JwtService,
  ) { 
    this.title = 'Sistema de Gestión de Entidades';
    this.subtitle = 'Bienvenido:';
    this.hide = true;
    this.loading = false;
    this.formReactive = this._formBuilder.group({
      username	      : ["", [Validators.required]],
      password	      : ["", [Validators.required]],
    });
  }

  ngOnInit(): void {}

  onSubmit(authRequestDTO: AuthRequestDTO): void {
    this.loading = true;
    this._authService.requestLogin(authRequestDTO).subscribe({
      next: (res) => {
        this.loading = false;
        this._jwtService.authJWT(res.data);
        this._router.navigateByUrl('/admin');
      },
      error: (err) => {
        this.loading = false;
      },
    });
  }

  goRegister(): void {
    this._router.navigateByUrl('/auth/register');
  }

}