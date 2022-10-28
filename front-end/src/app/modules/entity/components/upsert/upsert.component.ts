import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EntityRequestDTO } from '../../../../models/request/entity-request-dto';
import { TypeContributorResponseDTO } from '../../../../models/response/type-contributor-response-dto';
import { TypeDocumentResponseDTO } from '../../../../models/response/type-document-response-dto';
import { TypeContributorService } from '../../../../modules/type-contributor/services/type-contributor.service';
import { TypeDocumentService } from '../../../../modules/type-document/services/type-document.service';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { EntityService } from '../../services/entity.service';

@Component({
  selector: 'app-upsert',
  templateUrl: './upsert.component.html',
  styleUrls: ['./upsert.component.css']
})
export class UpsertComponent implements OnInit, OnDestroy {
  public title: string;
  @Input() id: number;
  public loading: boolean;
  public textBtnSubmit: string;
  public formReactive: FormGroup;
  public typeDocuments: TypeDocumentResponseDTO[] = [];
  public typeContributors: TypeContributorResponseDTO[] = [];

  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _snackBarService: SnackBarService,
    private _entityService: EntityService,
    private _typeContributorService: TypeContributorService, 
    private _typeDocumentService: TypeDocumentService, 
  ) { 
    this.title = 'Nueva entidad';
    this.id = 0;
    this.loading = false;
    this.textBtnSubmit = 'Registrar';
    this.formReactive = this._formBuilder.group({
      nroDocument	      : [null, [Validators.required, Validators.pattern(/^[0-9]{8}$/)]],
      companyName	      : [null, [Validators.required, Validators.pattern(/^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$/)]],
      commercialName    : [null, [Validators.required, Validators.pattern(/^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$/)]],
      address           : [null, [Validators.pattern(/^[a-zA-ZÀ-ÿ0-9,.\-\#\(\)°\/]+\s?(\s?[a-zA-ZÀ-ÿ0-9¿?,.\-\#\(\)°\/])+$/)]],
      phone             : [null, [Validators.required, Validators.pattern(/^[0-9]{7,9}$/)]],
      typeDocumentId    : [null, [Validators.required]],
      typeContributorId : [null, [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.setTypeContributors();
    this.setTypeDocuments();
    this.verifyId(this.id);
    
  }

  setTypeContributors(): void {
    this._typeContributorService.requestGetAll().subscribe({
      next: (res) => {
        this.typeContributors = res.data.elements;
      },
    });
  }

  setTypeDocuments(): void {
    this._typeDocumentService.requestGetAll().subscribe({
      next: (res) => {
        this.typeDocuments = res.data.elements;
      },
    });
  }

  verifyId(id: number): void{
    if(!(id===0 || id===null)){
      this.title = 'Editar entidad';
      this.textBtnSubmit = 'Actualizar';
      this.getById(id);
    }
  }

  onSubmit(entityRequestDTO: EntityRequestDTO): void {
    this.loading = true;
    if(this.id===0 || this.id===null){
      this.create(entityRequestDTO);
    }else{
      this.update(entityRequestDTO);
    }  
  }

  create(entityRequestDTO: EntityRequestDTO): void{
    this._entityService.requestCeate(entityRequestDTO).subscribe({
      next: (res) => {
        this.loading = false;
        this._router.navigateByUrl('/admin/entity/list');
        this._snackBarService.showInfo(res.message, 'top right', 5000);
      },
      error: (err) => {
        this.loading = false;
      },
    });
  }

  update(entityRequestDTO: EntityRequestDTO): void{
    this._entityService.requestUpdate(entityRequestDTO, this.id).subscribe({
      next: (res) => {
        this.loading = false;
        this._router.navigateByUrl('/admin/entity/list');
        this._snackBarService.showInfo(res.message, 'top right', 5000);
      },
      error: (err) => {
        this.loading = false;
      },
    });
  }
  
  getById(id: number): void {
    this._entityService.requestGetById(id).subscribe({
      next: (res) => {
        this.formReactive.controls['nroDocument'].setValue(res.data.nroDocument);
        this.formReactive.controls['companyName'].setValue(res.data.companyName);
        this.formReactive.controls['commercialName'].setValue(res.data.commercialName);
        this.formReactive.controls['address'].setValue(res.data.address);
        this.formReactive.controls['phone'].setValue(res.data.phone);
        this.formReactive.controls['typeDocumentId'].setValue(res.data.typeDocument.id);
        this.formReactive.controls['typeContributorId'].setValue(res.data.typeContributor.id);
      },
      error: (err) => {
        this._router.navigateByUrl('/admin/entity/list');
        if(err?.error?.message){
          this._snackBarService.showWarning(err.error.message, 'top right', 5000);
        }
      },
    });
	}

  goBack(): void {
    this._router.navigateByUrl('/admin/entity/list');
  }

  ngOnDestroy(): void { // ni bien de destruya el componente, se ejecutara este metodo para destruir a su vez la subscription
    // this._authSubscription?.unsubscribe(); 
  }

}