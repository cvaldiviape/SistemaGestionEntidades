import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EntityCreateComponent } from './pages/entity-create/entity-create.component';
import { EntityEditComponent } from './pages/entity-edit/entity-edit.component';
import { EntityListComponent } from './pages/entity-list/entity-list.component';
import { EntityRoutingModule } from './entity-routing.module';
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
    EntityCreateComponent,
    EntityEditComponent,
    EntityListComponent,
    UpsertComponent
  ],
  imports: [
    CommonModule,
    EntityRoutingModule,
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
export class EntityModule { }
