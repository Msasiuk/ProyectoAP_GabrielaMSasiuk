import { Component, OnInit } from '@angular/core';
import { SoftSkill } from 'src/app/model/soft-skill';
import { SoftSkillService } from 'src/app/service/soft-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-soft-skill',
  templateUrl: './soft-skill.component.html',
  styleUrls: ['./soft-skill.component.css'],
})
export class SoftSkillComponent implements OnInit {
  softSkill: SoftSkill[] = [];

  constructor(
    private softSkillService: SoftSkillService,
    private tokenService: TokenService
  ) {}
  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void {
    this.softSkillService.lista().subscribe((data) => {
      this.softSkill = data;
    });
  }

  delete(id: number) {
    if (id != undefined) {
      this.softSkillService.delete(id).subscribe(
        (data) => {
          this.cargarSkills();
        },
        (err) => {
          alert('No se pudo borrar la skill');
        }
      );
    }
  }
}
