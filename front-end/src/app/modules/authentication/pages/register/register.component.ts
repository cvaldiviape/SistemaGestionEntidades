import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequestDTO } from '../../../../models/request/user-request-dto';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
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
    private _snackBarService: SnackBarService,
  ) { 
    this.title = 'Sistema de Gestión de Entidades';
    this.subtitle = 'Registrate:';
    this.hide = true;
    this.loading = false;
    this.formReactive = this._formBuilder.group({
      username	      : ["", [Validators.required]],
      password	      : ["", [Validators.required]],
      repeatPassword	: ["", [Validators.required]],
    });
  }

  ngOnInit(): void {}

  onSubmit(userRequestDTO: UserRequestDTO): void {
    this.loading = true;

    if(userRequestDTO.password !== userRequestDTO.repeatPassword){
      this._snackBarService.showWarning('Las contraseñas ingresadas no coinciden!', 'top right');
      this.loading = false;
    }else{
      this._authService.requestRegister(userRequestDTO).subscribe({
        next: (res) => {
          this._router.navigateByUrl('/auth/sign-in');
          this._snackBarService.showInfo('Su cuenta ha sido creada exitosamente!', 'top right');
        },
        error: (err) => {
          this.loading = false;
        },
      });
    }   
  }

  goBack(): void {
    this._router.navigateByUrl('/auth/sign-in');
  }

}