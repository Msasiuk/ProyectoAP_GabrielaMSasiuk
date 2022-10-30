import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SoftSkill } from 'src/app/model/soft-skill';
import { SoftSkillService } from 'src/app/service/soft-skill.service';

@Component({
  selector: 'app-new-soft-skill',
  templateUrl: './new-soft-skill.component.html',
  styleUrls: ['./new-soft-skill.component.css'],
})
export class NewSoftSkillComponent implements OnInit {
  nombreSf: string;
  porcentajeSf: number;

  constructor(
    private softSkillService: SoftSkillService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const softSkill = new SoftSkill(this.nombreSf, this.porcentajeSf);
    this.softSkillService.save(softSkill).subscribe(
      (data) => {
        alert('Skill añadida correctamente');
        this.router.navigate(['']);
      },
      (err) => {
        alert('No se pudo añadir la skill');
        this.router.navigate(['']);
      }
    );
  }
}
