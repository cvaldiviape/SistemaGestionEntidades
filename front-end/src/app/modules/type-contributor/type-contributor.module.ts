import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TypeContributorCreateComponent } from './pages/type-contributor-create/type-contributor-create.component';
import { TypeContributorEditComponent } from './pages/type-contributor-edit/type-contributor-edit.component';
import { TypeContributorListComponent } from './pages/type-contributor-list/type-contributor-list.component';
import { TypeContributorRoutingModule } from './type-contributor-routing.module';
import { InputsModule } from '../../shared/components/inputs/inputs.module';
import { ButtonsModule } from '../../shared/components/buttons/buttons.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpsertComponent } from './components/upsert/upsert.component';

@NgModule({
  declarations: [
    TypeContributorCreateComponent,
    TypeContributorEditComponent,
    TypeContributorListComponent,
    UpsertComponent
  ],
  imports: [
    CommonModule,
    TypeContributorRoutingModule,
    ButtonsModule,
    InputsModule,
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
  ]
})
export class TypeContributorModule { }
