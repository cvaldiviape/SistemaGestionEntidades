import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from '../../shared/components/layouts/admin-layout/admin-layout.component';

const routes: Routes = [
  {
    path: '',
    component: AdminLayoutComponent,
    children: [
      {
        path: 'entity',
        loadChildren: () => import('../../modules/entity/entity.module').then(x => x.EntityModule),
      },
      {
        path: 'type-contributor',
        loadChildren: () => import('../../modules/type-contributor/type-contributor.module').then(x => x.TypeContributorModule),
      },
      {
        path: 'type-document',
        loadChildren: () => import('../../modules/type-document/type-document.module').then(x => x.TypeDocumentModule),
      },
      {
        path: '**',
        redirectTo: 'entity'
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
