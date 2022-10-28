import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TypeDocumentCreateComponent } from './pages/type-document-create/type-document-create.component';
import { TypeDocumentEditComponent } from './pages/type-document-edit/type-document-edit.component';
import { TypeDocumentListComponent } from './pages/type-document-list/type-document-list.component';

const routes: Routes = [
  {
    path: 'list',
    component: TypeDocumentListComponent
  },
  {
    path: 'create',
    component: TypeDocumentCreateComponent
  },
  {
    path: 'edit/:id',
    component: TypeDocumentEditComponent
  },
  {
    path: '**',
    redirectTo: 'list'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TypeDocumentRoutingModule { }