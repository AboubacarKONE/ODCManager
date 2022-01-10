import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from 'src/app/notification.service';
import { ExerciceServiceService } from '../Services/exercice-service.service';

@Component({
  selector: 'app-modifier-exercice',
  templateUrl: './modifier-exercice.component.html',
  styleUrls: ['./modifier-exercice.component.scss']
})
export class ModifierExerciceComponent implements OnInit {
  id : any;
  exo: any;
  constructor(
    private service: ExerciceServiceService,
    public route: ActivatedRoute,
    private notifyService : NotificationService,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.detailExercice(this.id).subscribe((data: any)=>{
      this.exo = data;
    })
  }

  updateExercice(){
    this.service.updateExercice(this.id, this.exo).subscribe((data: any)=>{
      this.exo = data;
      this.router.navigate(['/liste-exercice']);
      this.notifyService.showSuccess("Les Données ont été modifier avec succès !!");
    })
  }

}
