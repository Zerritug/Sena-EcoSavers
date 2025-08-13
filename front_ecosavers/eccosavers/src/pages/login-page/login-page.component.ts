import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginFooterComponent } from './login-footer/login-footer.component';
import { AuthService } from '../../shared/services/auth.service';
import { LoginCredentials } from '../../shared/models/login-credentials.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, LoginFormComponent, LoginFooterComponent],
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent {
  errorMessage = '';

  constructor(private auth: AuthService, private router: Router) {}

  onLogin(creds: LoginCredentials) {
    this.auth.login(creds).subscribe({
      next: (response) => {
        localStorage.setItem('token', response.token); //TOken jwt guardado
        this.router.navigate(['/usuarios']);
      },
      error: () => (this.errorMessage = 'Usuario o contraseña inválidos'),
    });
  }
}
