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
  imgP: string;
  linkP: string;
  fechaP: number;

  constructor(
    private proyectoServie: ProyectoService,
    private router: Router,
    public imageService: ImageService
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const proye = new Proyecto(
      this.nombreP,
      this.descripcionP,
      this.imgP,
      this.linkP,
      this.fechaP
    );
    this.proyectoServie.save(proye).subscribe(
      (data) => {
        alert('Proyecto añadido');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Falló');
        this.router.navigate(['']);
      }
    );
  }
}
