import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { EntityResponseDTO } from '../../../../models/response/entity-response-dto';
import { DialogService } from '../../../../shared/components/dialogs/services/dialog.service';
import { SnackBarService } from '../../../../shared/services/snack-bar.service';
import { EntityService } from '../../services/entity.service';

@Component({
  selector: 'app-entity-list',
  templateUrl: './entity-list.component.html',
  styleUrls: ['./entity-list.component.css']
})
export class EntityListComponent implements OnInit {
  public title: string;
  public displayedColumns: string[];
  public dataSource!: MatTableDataSource<EntityResponseDTO>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private _router: Router,
    private _snackBarService: SnackBarService,
    private _entityService: EntityService,
    private _dialogService: DialogService
  ) {
    this.title = "Entidades";
    this.displayedColumns = ['id','companyName','nroDocument','commercialName','actions'];
    this.getAllItems();
  }

  ngOnInit(): void {}

  getAllItems(): void {
    this._entityService.requestGetAll().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource<EntityResponseDTO>(res.data.elements);
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
    this._router.navigateByUrl('/admin/entity/create');
  }

  goPageEdit(id: number): void {
    this._router.navigateByUrl(`/admin/entity/edit/${id}`);
  }

  openDialogDelete(id: number, companyName: string) {
    this._dialogService.confirmDialog({
      title: `Esta seguro que desea eliminar la entidad '${companyName}'?`,
      message: 'Una vez eliminado, ya no podrá ser recuperado.',
      confirmText: 'Si',
      cancelText: 'No',
    })
    .subscribe((yes) => { if (yes) this.delete(id)});
  }

  delete(id: number): void {
    this._entityService.requestDelete(id).subscribe({
      next: (res) => {
        if(res.success){
          this.getAllItems();
          this._snackBarService.showInfo(res.message, 'top right', 5000);
        }
      }
    });
  }

}