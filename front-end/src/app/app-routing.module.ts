import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoadGuard } from './security/guards/admin/admin-load.guard';
import { AuthLoadGuard } from './security/guards/auth/auth-load.guard';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./router/auth/auth.module').then((m) => m.AuthModule),
    canLoad: [AuthLoadGuard]
  },
  {
    path: 'admin',
    loadChildren: () => import('./router/admin/admin.module').then((m) => m.AdminModule),
    canLoad: [AdminLoadGuard]
  },
  {
    path: '**',
    redirectTo: 'auth'
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }