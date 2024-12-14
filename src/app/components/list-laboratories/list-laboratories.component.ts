import { Component, OnInit } from '@angular/core';
import { LaboratoireService } from '../../services/laboratoire.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AddLaboratoryComponent } from '../add-laboratory/add-laboratory.component';
import { DeleteLaboratoryComponent } from '../delete-laboratory/delete-laboratory.component';
import { EditLaboratoryComponent } from '../edit-laboratory/edit-laboratory.component';

@Component({
  selector: 'app-list-laboratories',
  templateUrl: './list-laboratories.component.html',
  styleUrls: ['./list-laboratories.component.css'] // Correction ici (pluriel)
})
export class ListLaboratoriesComponent implements OnInit {

  laboratoires: any[] = []; // Tableau pour stocker les laboratoires
  selectedLabo: any = null; // Propriété pour le laboratoire sélectionné pour l'édition

  constructor(
    private laboratoireService: LaboratoireService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadLaboratoires();
  }

  loadLaboratoires(): void {
    // Récupération des laboratoires au chargement du composant
    this.laboratoireService.getLaboratoires().subscribe(
      (data: any[]) => {
        this.laboratoires = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des laboratoires', error);
      }
    );
  }

  openAddLaboratory(): void {
    console.log('Ajouter un laboratoire');
    const dialogRef = this.dialog.open(AddLaboratoryComponent, {
      width: '500px'
    });
    dialogRef.afterClosed().subscribe((result) => {
        this.loadLaboratoires(); // Rafraîchir la liste
    });
  }

  openDeleteDialog(laboId: number): void {
    const dialogRef = this.dialog.open(DeleteLaboratoryComponent, {
      width: '400px',
      data: { id: laboId }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result === true) {
        this.loadLaboratoires(); // Chargez les laboratoires
      }
    });
  }

  openEditDialog(id: number): void {
    const dialogRef = this.dialog.open(EditLaboratoryComponent, {
      width: '400px',
      data: { id: id }  // Passez l'ID du laboratoire ici
    });
    dialogRef.componentInstance.laboratoryUpdated.subscribe(() => {
      // Rafraîchir la liste après la mise à jour
      this.loadLaboratoires();
    });
  }
  
  
  
}
