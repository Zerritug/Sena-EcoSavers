import { RouterModule, Routes } from '@angular/router';

import { PersonComponent } from '../pages/Person/person/person.component';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { NgModule } from '@angular/core';
import { LoginPageComponent } from '../pages/login-page/login-page.component';


export const routes: Routes = [
  { path: 'person', component: PersonComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'login',  component: LoginPageComponent },

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' },
];
