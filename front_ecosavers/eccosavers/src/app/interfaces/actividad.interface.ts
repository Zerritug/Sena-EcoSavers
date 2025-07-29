export interface Actividad {
  id: string;
  fecha: Date;
  tipo: 'reciclaje' | 'educacion' | 'campana';
  titulo: string;
  ubicacion?: string;
  duracion?: string;
  dispositivos?: string[];
  rol?: string;
}
