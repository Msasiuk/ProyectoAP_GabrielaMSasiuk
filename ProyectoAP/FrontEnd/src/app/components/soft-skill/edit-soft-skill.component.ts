import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SoftSkill } from 'src/app/model/soft-skill';
import { SoftSkillService } from 'src/app/service/soft-skill.service';

@Component({
  selector: 'app-edit-soft-skill',
  templateUrl: './edit-soft-skill.component.html',
  styleUrls: ['./edit-soft-skill.component.css'],
})
export class EditSoftSkillComponent implements OnInit {
  softSkill: SoftSkill = null;

  constructor(
    private softSkillService: SoftSkillService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.softSkillService.detail(id).subscribe(
      (data) => {
        this.softSkill = data;
      },
      (err) => {
        alert('No se pudo modificar la skill');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.softSkillService.update(id, this.softSkill).subscribe(
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
