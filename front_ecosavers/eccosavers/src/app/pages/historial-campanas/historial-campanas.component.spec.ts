import { Component, OnInit } from '@angular/core';
import { HistorialService } from '../../services/historial.service';
import { Actividad } from '../../interfaces/actividad.interface';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.scss']
})
export class HistorialComponent implements OnInit {

  actividades: Actividad[] = [];
  filtroActivo: string = 'todos';

  constructor(private historialService: HistorialService) {}

  ngOnInit(): void {
    this.cargarActividades();
  }

  cambiarFiltro(filtro: string): void {
    this.filtroActivo = filtro;
    this.cargarActividades();
  }

  cargarActividades(): void {
    this.actividades = this.historialService.getActividadesByTipo(this.filtroActivo);
  }

  formatearFecha(fecha: Date): string {
    return fecha.toLocaleDateString('es-ES', {
      day: '2-digit',
      month: 'long',
      year: 'numeric'
    });
  }

  descargarCertificado(): void {
    alert('Descargando certificado...');
  }
}
