import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardSkill } from 'src/app/model/hard-skill';
import { HardSkillService } from 'src/app/service/hard-skill.service';

@Component({
  selector: 'app-new-hard-skill',
  templateUrl: './new-hard-skill.component.html',
  styleUrls: ['./new-hard-skill.component.css'],
})
export class NewHardSkillComponent implements OnInit {
  nombreHd: string;
  porcentajeHd: number;

  constructor(
    private hardSkillService: HardSkillService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const hardSkill = new HardSkill(this.nombreHd, this.porcentajeHd);
    this.hardSkillService.save(hardSkill).subscribe(
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
