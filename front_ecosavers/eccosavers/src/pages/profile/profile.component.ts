// profile.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  // ← importa CommonModule

@Component({
  standalone: true,
  selector: 'app-profile',
  imports: [ CommonModule ],                 // ← agrégalo aquí
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  activeTab: 'personal' | 'security' = 'personal';

  selectTab(tab: 'personal' | 'security') {
    this.activeTab = tab;
  }
}
