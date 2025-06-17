import { Component, OnInit } from '@angular/core';
import { PersonService } from '../services/person.service'; // Asegúrate de que la ruta a PersonService sea correcta
import { PersonModel } from '../interfaces/PersonsModel';
import { CommonModule } from '@angular/common'; // Importa CommonModule (contiene NgFor)
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from '../../../shared/header/header.component';
import { FooterComponent } from '../../../shared/footer/footer.component'; // Asegúrate de esta importación

@Component({
  selector: 'app-person',
  imports: [CommonModule, HttpClientModule, HeaderComponent, FooterComponent],
  templateUrl: './person.component.html',
  styleUrl: './person.component.scss',
})
export class PersonComponent implements OnInit {
  persons: PersonModel[] = [];
  selectedPerson: PersonModel | null = null;

  constructor(private personService: PersonService) {}

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
  deletePerson(person: PersonModel): void {
    this.personService.deletePerson(person.id).subscribe(
      () => {
        this.loadPersons();
      },
      (error: any) => {
        console.error('Error deleting person:', error);
      }
    );
  }

  clearSelection(): void {
    this.selectedPerson = null;
  }
}
