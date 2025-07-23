import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from '../pages/home-page/home-page.component';
import { PersonComponent } from '../pages/Person/person/person.component';
import { ProfileComponent } from '../pages/profile/profile.component';

// Exporta la constante para que app.config.ts pueda importarla
export const routes: Routes = [
  { path: 'home',    component: HomePageComponent },
  { path: 'person',  component: PersonComponent },
  { path: 'profile', component: ProfileComponent },

  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' },
];

@NgModule({
  imports: [
    // Puedes agregar opciones como initialNavigation si usas SSR
    RouterModule.forRoot(routes /*, { initialNavigation: 'enabledBlocking' } */)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
