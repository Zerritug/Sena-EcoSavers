import { Routes } from '@angular/router';
import { PublicationsComponent } from '../pages/Publications/publications/publications.component';
import { PersonComponent } from '../pages/Person/person/person.component';
import { MenuSuperiorComponent } from '../pages/MenuSuperior/menu-superior/menu-superior.component';
import { FooterComponent } from '../pages/Footer/footer/footer.component';

export const routes: Routes = [
  { path: 'publications', component: PublicationsComponent },
  { path: 'person', component: PersonComponent },
  { path: 'menu-superior', component: MenuSuperiorComponent },
  { path: 'footer', component: FooterComponent },
  { path: '', redirectTo: '/publications', pathMatch: 'full' }, // Ruta por defecto
  { path: '**', redirectTo: '/publications' } // Ruta para manejar errores 404
];