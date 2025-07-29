import { Injectable } from '@angular/core';
import { Actividad } from '../interfaces/actividad.interface';

@Injectable({
  providedIn: 'root'
})
export class HistorialService {

  private actividades: Actividad[] = [
    {
      id: '1',
      fecha: new Date('2024-10-15'),
      tipo: 'reciclaje',
      titulo: 'Reciclaje de dispositivos',
      ubicacion: 'EcoRed Reciclaje, Bogotá',
      dispositivos: ['Smartphone Samsung Galaxy S8', 'Batería de laptop HP']
    },
    {
      id: '2',
      fecha: new Date('2024-10-02'),
      tipo: 'reciclaje',
      titulo: 'Reciclaje de dispositivos',
      ubicacion: 'GreenTech Reciclaje, Medellín',
      dispositivos: ['Monitor LG 24 pulgadas', 'Teclado inalámbrico']
    },
    {
      id: '3',
      fecha: new Date('2024-09-28'),
      tipo: 'educacion',
      titulo: 'Curso: Reciclaje de dispositivos electrónicos',
      duracion: '2 horas'
    },
    {
      id: '4',
      fecha: new Date('2024-09-15'),
      tipo: 'educacion',
      titulo: 'Webinar: Impacto ambiental de los RAEE',
      duracion: '1 hora'
    },
    {
      id: '5',
      fecha: new Date('2024-09-10'),
      tipo: 'campana',
      titulo: 'Campaña de recolección en centro comercial',
      ubicacion: 'Centro Comercial Gran Estación, Bogotá',
      rol: 'Voluntario'
    }
  ];

  getAllActividades(): Actividad[] {
    return [...this.actividades];
  }

  getActividadesByTipo(tipo: string): Actividad[] {
    if (tipo === 'todos') return this.getAllActividades();
    if (tipo === 'campanas') tipo = 'campana';
    return this.actividades.filter(actividad => actividad.tipo === tipo);
  }
}
