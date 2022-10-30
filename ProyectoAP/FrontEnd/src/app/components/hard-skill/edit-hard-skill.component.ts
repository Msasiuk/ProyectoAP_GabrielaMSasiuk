import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HardSkill } from 'src/app/model/hard-skill';
import { HardSkillService } from 'src/app/service/hard-skill.service';

@Component({
  selector: 'app-edit-hard-skill',
  templateUrl: './edit-hard-skill.component.html',
  styleUrls: ['./edit-hard-skill.component.css'],
})
export class EditHardSkillComponent implements OnInit {
  hardSkill: HardSkill = null;

  constructor(
    private hardSkillService: HardSkillService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hardSkillService.detail(id).subscribe(
      (data) => {
        this.hardSkill = data;
      },
      (err) => {
        alert('No se pudo modificar la skill');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hardSkillService.update(id, this.hardSkill).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('No se pudo modificar la skill');
        this.router.navigate(['']);
      }
    );
  }
}
