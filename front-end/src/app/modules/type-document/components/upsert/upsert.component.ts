import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TypeDocumentRequestDTO } from '../../../../models/request/type-document-request-dto';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { TypeDocumentService } from '../../services/type-document.service';

@Component({
  selector: 'app-upsert',
  templateUrl: './upsert.component.html',
  styleUrls: ['./upsert.component.css']
})
export class UpsertComponent implements OnInit {
  public title: string;
  @Input() id: number;
  public loading: boolean;
  public textBtnSubmit: string;
  public formReactive: FormGroup;

  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _snackBarService: SnackBarService,
    private _typeDocumentService: TypeDocumentService,
  ) { 
    this.title = 'Nuevo tipo de documento';
    this.id = 0;
    this.loading = false;
    this.textBtnSubmit = 'Registrar';
    this.formReactive = this._formBuilder.group({
      code	      : [null, [Validators.required, Validators.pattern(/^[a-zA-ZÀ-ÿ0-9]+$/)]],
      name	      : [null, [Validators.required, Validators.pattern(/^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$/)]],
      description : [null, [Validators.pattern(/^[a-zA-ZÀ-ÿ0-9¿?,.\"\'%!¡:\-\#$\(\)]+(\s?[a-zA-ZÀ-ÿ0-9¿?,.\"\'%!¡:\-\#$\(\)])+$/)]],
    });
  }

  ngOnInit(): void {
    this.verifyId(this.id);
  }

  verifyId(id: number): void{
    if(!(id===0 || id===null)){
      this.title = 'Editar tipo de documento';
      this.textBtnSubmit = 'Actualizar';
      this.getById(id);
    }
  }

  onSubmit(typeDocumentRequestDTO: TypeDocumentRequestDTO): void {
    this.loading = true;
    if(this.id===0 || this.id===null){
      this._typeDocumentService.requestCeate(typeDocumentRequestDTO).subscribe({
        next: (res) => {
          this.loading = false;
          this._router.navigateByUrl('/admin/type-document/list');
          this._snackBarService.showInfo(res.message, 'top right', 5000);
        },
        error: (err) => {
          this.loading = false;
        },
      });
    }else{
      this._typeDocumentService.requestUpdate(typeDocumentRequestDTO, this.id).subscribe({
        next: (res) => {
          this.loading = false;
          this._router.navigateByUrl('/admin/type-document/list');
          this._snackBarService.showInfo(res.message, 'top right', 5000);
        },
        error: (err) => {
          this.loading = false;
        },
      });
    }  
  }
  
  getById(id: number): void {
    this._typeDocumentService.requestGetById(id).subscribe({
      next: (res) => {
        this.formReactive.controls['code'].setValue(res.data.code);
        this.formReactive.controls['name'].setValue(res.data.name);
        this.formReactive.controls['description'].setValue(res.data.description || '');
      },
      error: (err) => {
        this._router.navigateByUrl('/admin/type-document/list');
        if(err?.error?.message){
          this._snackBarService.showWarning(err.error.message, 'top right', 5000);
        }
      },
    });
	}

  goBack(): void {
    this._router.navigateByUrl('/admin/type-document/list');
  }

}