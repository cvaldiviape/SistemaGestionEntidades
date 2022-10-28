import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { TypeDocumentResponseDTO } from '../../../../models/response/type-document-response-dto';
import { DialogService } from '../../../../shared/components/dialogs/services/dialog.service';
import { TypeDocumentService } from '../../services/type-document.service';

@Component({
  selector: 'app-type-document-list',
  templateUrl: './type-document-list.component.html',
  styleUrls: ['./type-document-list.component.css']
})

export class TypeDocumentListComponent implements OnInit {
  public title: string;
  public displayedColumns: string[];
  public dataSource!: MatTableDataSource<TypeDocumentResponseDTO>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private _router: Router,
    private _snackBarService: SnackBarService,
    private _typeDocumentService: TypeDocumentService,
    private _dialogService: DialogService
  ) {
    this.title = "Tipos de Documentos";
    this.displayedColumns = ['id','code','name','description','actions'];
    this.getAllItems();
  }

  ngOnInit(): void {}

  getAllItems(): void {
    this._typeDocumentService.requestGetAll().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource<TypeDocumentResponseDTO>(res.data.elements);
        this.dataSource.paginator = this.paginator;
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  goPageCreate(): void {
    this._router.navigateByUrl('/admin/type-document/create');
  }

  goPageEdit(id: number): void {
    this._router.navigateByUrl(`/admin/type-document/edit/${id}`);
  }

  openDialogDelete(id: number, name: string) {
    this._dialogService.confirmDialog({
      title: `Esta seguro que desea eliminar el tipo de documento '${name}'?`,
      message: 'Una vez eliminado, ya no podrá ser recuperado.',
      confirmText: 'Si',
      cancelText: 'No',
    })
    .subscribe((yes) => { if (yes) this.delete(id)});
  }

  delete(id: number): void {
    this._typeDocumentService.requestDelete(id).subscribe({
      next: (res) => {
        if(res.success){
          this.getAllItems();
          this._snackBarService.showInfo(res.message, 'top right', 5000);
        }
      }
    });
  }

}