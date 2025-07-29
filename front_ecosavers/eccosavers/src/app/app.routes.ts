feat-perfil-gestion-perfil-user-eco-25
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from '../pages/home-page/home-page.component';
import { PersonComponent } from '../pages/Person/person/person.component';
import { ProfileComponent } from '../pages/profile/profile.component';
import { Routes } from '@angular/router';
import { HomePageComponent } from '../pages/home-page/home-page.component';
feat-auth-Login-Inicio-Sesion-SeguroJ-WT-ECO-19
import { NgModule } from '@angular/core';
import { LoginPageComponent } from '../pages/login-page/login-page.component';


import { PersonComponent } from '../pages/Person/person/person.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { PuntosReciclajeComponent } from './pages/puntos-reciclaje/puntos-reciclaje.component';
import { EstadisticasComponent } from './pages/estadisticas/estadisticas.component';
 develop develop

export const routes: Routes = [
feat-perfil-gestion-perfil-user-eco-25
  { path: 'home',    component: HomePageComponent },
  { path: 'person',  component: PersonComponent },
  { path: 'profile', component: ProfileComponent },

  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'puntos-reciclaje', component: PuntosReciclajeComponent },
  { path: 'estadisticas', component: EstadisticasComponent },
  { path: 'home', component: HomePageComponent },
 feat-auth-Login-Inicio-Sesion-SeguroJ-WT-ECO-19
  { path: 'login',  component: LoginPageComponent },
  { path: 'person', component: PersonComponent },
develop

  { path: '', redirectTo: 'usuarios', pathMatch: 'full' },
  { path: '**', redirectTo: 'usuarios' } develop
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes 
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
