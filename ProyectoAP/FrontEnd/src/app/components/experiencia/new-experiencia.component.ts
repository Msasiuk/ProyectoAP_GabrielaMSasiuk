import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/experiencia.service';
import { ImageService } from 'src/app/service/image.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css'],
})
export class NewExperienciaComponent implements OnInit {
  empresaEx: string;
  tituloEx: string;
  descripcionEx: string;
  imgEmpresaEx: string;
  fechaInicioEx: number;
  fechaFinEx: number;

  constructor(
    private sExperiencia: SExperienciaService,
    private router: Router,
    public imageService: ImageService
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const expe = new Experiencia(
      this.empresaEx,
      this.tituloEx,
      this.descripcionEx,
      this.imgEmpresaEx,
      this.fechaInicioEx,
      this.fechaFinEx
    );
    this.sExperiencia.save(expe).subscribe(
      (data) => {
        alert('Experiencia añadida');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Falló');
        this.router.navigate(['']);
      }
    );
  }
}
