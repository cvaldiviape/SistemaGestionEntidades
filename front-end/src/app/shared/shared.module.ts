import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutsModule } from './components/layouts/layouts.module';
import { ButtonsModule } from './components/buttons/buttons.module';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { InputsModule } from './components/inputs/inputs.module';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { getSpanichPaginatorIntl } from './static/spanish-paginator';
import { OthersModule } from './components/others/others.module';
import { DialogsModule } from './components/dialogs/dialogs.module';

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    LayoutsModule,
    ButtonsModule,
    InputsModule,
    OthersModule,
    DialogsModule,
    MatSnackBarModule
  ],
  providers: [{ provide: MatPaginatorIntl, useValue: getSpanichPaginatorIntl() }],
})
export class SharedModule { }