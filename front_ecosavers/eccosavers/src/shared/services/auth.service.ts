import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginCredentials } from '../models/login-credentials.model';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiUrl = '/api/login';

  constructor(private http: HttpClient) {}

  login(creds: LoginCredentials): Observable<any> {
    return this.http.post(this.apiUrl, creds);
  }
}
