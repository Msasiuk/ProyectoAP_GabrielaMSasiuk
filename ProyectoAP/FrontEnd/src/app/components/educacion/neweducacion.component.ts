import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { ImageService } from 'src/app/service/image.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css'],
})
export class NeweducacionComponent implements OnInit {
  institucionEd: string;
  tituloEd: string;
  imgInstitucionEd: string;
  fechaInicioEd: number;
  fechaFinEd: number;

  constructor(
    private educacionService: EducacionService,
    private router: Router,
    public imageService: ImageService
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const edu = new Educacion(
      this.institucionEd,
      this.tituloEd,
      this.imgInstitucionEd,
      this.fechaInicioEd,
      this.fechaFinEd
    );
    this.educacionService.save(edu).subscribe(
      (data) => {
        alert('Educación añadida');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Falló');
        this.router.navigate(['']);
      }
    );
  }
}
