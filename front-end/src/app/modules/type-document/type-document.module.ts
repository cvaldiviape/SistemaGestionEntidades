import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TypeDocumentCreateComponent } from './pages/type-document-create/type-document-create.component';
import { TypeDocumentEditComponent } from './pages/type-document-edit/type-document-edit.component';
import { TypeDocumentListComponent } from './pages/type-document-list/type-document-list.component';
import { TypeDocumentRoutingModule } from './type-document-routing.module';
import { InputsModule } from '../../shared/components/inputs/inputs.module';
import { ButtonsModule } from '../../shared/components/buttons/buttons.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule, MatPaginatorIntl } from '@angular/material/paginator';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OthersModule } from '../../shared/components/others/others.module';
import { UpsertComponent } from './components/upsert/upsert.component';

@NgModule({
  declarations: [
    TypeDocumentCreateComponent,
    TypeDocumentEditComponent,
    TypeDocumentListComponent,
    UpsertComponent
  ],
  imports: [
    CommonModule,
    TypeDocumentRoutingModule,
    ButtonsModule,
    InputsModule,
    OthersModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatNativeDateModule,
    MatFormFieldModule, 
    MatInputModule, 
    MatIconModule, 
    MatTableModule,
    MatPaginatorModule,
    MatDatepickerModule,
    MatButtonToggleModule,
    MatMenuModule,
    MatRadioModule,
    MatSelectModule,
    MatDialogModule
  ],
})
export class TypeDocumentModule { }
