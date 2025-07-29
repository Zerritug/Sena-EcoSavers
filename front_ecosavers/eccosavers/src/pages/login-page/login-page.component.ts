import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginFooterComponent } from './login-footer/login-footer.component';
import { AuthService } from '../../shared/services/auth.service';
import { LoginCredentials } from '../../shared/models/login-credentials.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  standalone: true,                             // ← marca como standalone
  imports: [
    CommonModule,                                // ← para *ngIf
    LoginFormComponent,                          // ← tu form
    LoginFooterComponent                         // ← tu footer
  ],
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {
  errorMessage = '';

  constructor(
    private auth: AuthService,
    private router: Router
  ) {}

  onLogin(creds: LoginCredentials) {
    this.auth.login(creds).subscribe({
      next: () => this.router.navigate(['/home']),
      error: () => this.errorMessage = 'Usuario o contraseña inválidos'
    });
  }
}
