import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PuntosReciclajeComponent } from './puntos-reciclaje.component';

describe('PuntosReciclajeComponent', () => {
  let component: PuntosReciclajeComponent;
  let fixture: ComponentFixture<PuntosReciclajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PuntosReciclajeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PuntosReciclajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
