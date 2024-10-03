import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { ChartModule } from 'primeng/chart';

export const appConfig: ApplicationConfig = {
  providers: [provideHttpClient(), 
    ChartModule,
    provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes)]
};
