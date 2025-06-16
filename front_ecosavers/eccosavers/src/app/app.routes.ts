import { RouterModule, Routes } from '@angular/router';
import { PublicationsComponent } from '../pages/Publications/publications/publications.component';
import { PersonComponent } from '../pages/Person/person/person.component';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  { path: 'publications', component: PublicationsComponent },
  { path: 'person', component: PersonComponent },
  { path: 'home', component: HomePageComponent },

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' },
];
