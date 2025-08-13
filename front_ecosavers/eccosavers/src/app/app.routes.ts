import { RouterModule, Routes } from '@angular/router';

import { PersonComponent } from '../pages/Person/person/person.component';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  { path: 'person', component: PersonComponent },
  { path: 'home', component: HomePageComponent },

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' },
];
