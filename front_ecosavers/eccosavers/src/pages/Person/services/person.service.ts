import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonModel } from '../interfaces/PersonsModel'; // Asegúrate de que la ruta a Person.ts sea correcta

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private apiUrl = 'http://localhost:8080/api/persons/getAll'; // La URL correcta de tu backend
  constructor(private http: HttpClient) { }

  getAllPersons(): Observable<PersonModel[]> {
    return this.http.get<PersonModel[]>(this.apiUrl);
  }
}