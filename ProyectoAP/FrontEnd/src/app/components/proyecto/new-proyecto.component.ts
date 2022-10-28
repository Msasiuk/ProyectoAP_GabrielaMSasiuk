import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css'],
})
export class NewProyectoComponent implements OnInit {
  nombreP: string;
  descripcionP: string;
  linkP: string;
  imgP: string;
  fechaInicioP: number;
  fechaFinP: number;

  constructor(
    private proyectoS: ProyectoService,
    private activatedRouter: ActivatedRoute,
    private router: Router,
    public imageService: ImageService
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const proyecto = new Proyecto(
      this.nombreP,
      this.descripcionP,
      this.linkP,
      this.imgP,
      this.fechaInicioP,
      this.fechaFinP
    );
    this.proyectoS.save(proyecto).subscribe(
      (data) => {
        alert('Proyecto añadido correctamente');
        this.router.navigate(['']);
      },
      (err) => {
        alert('No se pudo añadir el proyecto');
        this.router.navigate(['']);
      }
    );
  }

  uploadImage($event: any) {
    const id = this.activatedRouter.snapshot.params['id'];
    const name = 'proyecto_' + id;
    this.imageService.uploadImage($event, name);
  }
}
