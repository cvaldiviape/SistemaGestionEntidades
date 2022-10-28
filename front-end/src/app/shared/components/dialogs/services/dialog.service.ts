import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { ConfirmDialogData } from '../../../../models/others/confirm-dialog-data';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(
    private _dialog: MatDialog
  ) { }

  confirmDialog(data: ConfirmDialogData): Observable<boolean> {
    return this._dialog.open(ConfirmDialogComponent, {
      data,
      width: '500px',
      disableClose: true
    }).afterClosed();
  }
}
