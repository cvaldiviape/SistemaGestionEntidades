import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { DialogService } from '../../../../shared/components/dialogs/services/dialog.service';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { TypeContributorResponseDTO } from '../../../../models/response/type-contributor-response-dto';
import { TypeContributorService } from '../../services/type-contributor.service';

@Component({
  selector: 'app-type-contributor-list',
  templateUrl: './type-contributor-list.component.html',
  styleUrls: ['./type-contributor-list.component.css']
})
export class TypeContributorListComponent implements OnInit {
  public title: string;
  public displayedColumns: string[];
  public dataSource!: MatTableDataSource<TypeContributorResponseDTO>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private _router: Router,
    private _snackBarService: SnackBarService,
    private _typeContributorService: TypeContributorService,
    private _dialogService: DialogService
  ) {
    this.title = "Tipos de Contribuyentes";
    this.displayedColumns = ['id','name','actions'];
    this.getAllItems();
  }

  ngOnInit(): void {}

  getAllItems(): void {
    this._typeContributorService.requestGetAll().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource<TypeContributorResponseDTO>(res.data.elements);
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
    this._router.navigateByUrl('/admin/type-contributor/create');
  }

  goPageEdit(id: number): void {
    this._router.navigateByUrl(`/admin/type-contributor/edit/${id}`);
  }

  openDialogDelete(id: number, name: string) {
    this._dialogService.confirmDialog({
      title: `Esta seguro que desea eliminar el tipo de contribuyente '${name}'?`,
      message: 'Una vez eliminado, ya no podrá ser recuperado.',
      confirmText: 'Si',
      cancelText: 'No',
    })
    .subscribe((yes) => { if (yes) this.delete(id)});
  }

  delete(id: number): void {
    this._typeContributorService.requestDelete(id).subscribe({
      next: (res) => {
        if(res.success){
          this.getAllItems();
          this._snackBarService.showInfo(res.message, 'top right', 5000);
        }
      }
    });
  }

}