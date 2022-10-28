import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntityCreateComponent } from './pages/entity-create/entity-create.component';
import { EntityEditComponent } from './pages/entity-edit/entity-edit.component';
import { EntityListComponent } from './pages/entity-list/entity-list.component';

const routes: Routes = [
  {
    path: 'list',
    component: EntityListComponent
  },
  {
    path: 'create',
    component: EntityCreateComponent
  },
  {
    path: 'edit/:id',
    component: EntityEditComponent
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
export class EntityRoutingModule { }
