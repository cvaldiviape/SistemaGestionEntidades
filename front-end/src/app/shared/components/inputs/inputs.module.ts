import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChipComponent } from './chip/chip.component';
import { TextareaComponent } from './textarea/textarea.component';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatChipsModule } from '@angular/material/chips';
import { MatSelectModule } from '@angular/material/select';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputFileComponent } from './input-file/input-file.component';

@NgModule({
  declarations: [
    ChipComponent,
    TextareaComponent,
    InputFileComponent,
  ],
  imports: [
    CommonModule,
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
    MatChipsModule,
    MatSelectModule,
    MatAutocompleteModule,
  ],
  exports: [
    ChipComponent,
    TextareaComponent,
    InputFileComponent,
  ]
})
export class InputsModule { }
