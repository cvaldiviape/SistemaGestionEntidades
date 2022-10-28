import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TypeContributorCreateComponent } from './pages/type-contributor-create/type-contributor-create.component';
import { TypeContributorEditComponent } from './pages/type-contributor-edit/type-contributor-edit.component';
import { TypeContributorListComponent } from './pages/type-contributor-list/type-contributor-list.component';

const routes: Routes = [
  {
    path: 'list',
    component: TypeContributorListComponent
  },
  {
    path: 'create',
    component: TypeContributorCreateComponent
  },
  {
    path: 'edit/:id',
    component: TypeContributorEditComponent
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
export class TypeContributorRoutingModule { }