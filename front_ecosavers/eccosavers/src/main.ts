import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { serverRoutes } from './app/app.routes.server';
import { importProvidersFrom } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

bootstrapApplication(AppComponent, {
  providers: [
    ...(appConfig.providers || []),
    provideRouter(serverRoutes),
    importProvidersFrom(ReactiveFormsModule),
    importProvidersFrom(HttpClientModule),
  ],
  // Spread the rest of appConfig except providers
  ...Object.fromEntries(Object.entries(appConfig).filter(([key]) => key !== 'providers'))
})
  .catch((err) => console.error(err));
