import { Component, OnInit } from '@angular/core';
import { HardSkill } from 'src/app/model/hard-skill';
import { HardSkillService } from 'src/app/service/hard-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hard-skill',
  templateUrl: './hard-skill.component.html',
  styleUrls: ['./hard-skill.component.css'],
})
export class HardSkillComponent implements OnInit {
  hardSkill: HardSkill[] = [];

  constructor(
    private hardSkillService: HardSkillService,
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
    this.hardSkillService.lista().subscribe((data) => {
      this.hardSkill = data;
    });
  }

  delete(id: number) {
    if (id != undefined) {
      this.hardSkillService.delete(id).subscribe(
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
