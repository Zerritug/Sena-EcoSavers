import { Component, OnInit } from '@angular/core';
import { PersonService } from '../services/person.service'; // Asegúrate de que la ruta a PersonService sea correcta
import { PersonModel } from '../interfaces/PersonsModel';
import { CommonModule } from '@angular/common'; // Importa CommonModule (contiene NgFor)
import { HttpClientModule } from '@angular/common/http'; // Asegúrate de esta importación

@Component({
  selector: 'app-person',
  imports: [CommonModule, HttpClientModule],
  templateUrl: './person.component.html',
  styleUrl: './person.component.scss'
})
export class PersonComponent implements OnInit {
  persons: PersonModel[] = [];
  selectedPerson: PersonModel | null = null;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.loadPersons();
  }

  loadPersons(): void {
    this.personService.getAllPersons().subscribe(
      (data: PersonModel[]) => {
        this.persons = data;
      },
      (error) => {
        console.error('Error fetching persons:', error);
      }
    );
  }

  selectPerson(person: PersonModel): void {
    this.selectedPerson = person;
  }

  clearSelection(): void {
    this.selectedPerson = null;
  }
  
}

