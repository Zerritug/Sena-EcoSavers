import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PersonComponent } from '../pages/Person/person/person.component';
import { ProfileComponent } from '../pages/profile/profile.component';
import { LoginPageComponent } from '../pages/login-page/login-page.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { PuntosReciclajeComponent } from './pages/puntos-reciclaje/puntos-reciclaje.component';
import { EstadisticasComponent } from './pages/estadisticas/estadisticas.component';

export const routes: Routes = [
  {
    path: 'home',
    loadComponent: () =>
      import('../pages/home-page/home-page.component').then(
        (m) => m.HomePageComponent
      ),
  },

  { path: 'person', component: PersonComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'puntos-reciclaje', component: PuntosReciclajeComponent },
  { path: 'estadisticas', component: EstadisticasComponent },
  { path: 'login', component: LoginPageComponent },
  {
    path: 'historial',
    loadComponent: () =>
      import('./pages/historial/historial.component').then(
        (m) => m.HistorialComponent
      ),
  },
  { path: '', redirectTo: 'usuarios', pathMatch: 'full' },
  { path: '**', redirectTo: 'usuarios' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
