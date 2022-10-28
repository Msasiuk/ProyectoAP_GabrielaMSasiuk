export class Proyecto {
  id?: number;
  nombreP: string;
  descripcionP: string;
  linkP: string;
  imgP: string;
  fechaInicioP: number;
  fechaFinP: number;

  constructor(
    nombreP: string,
    descripcionP: string,
    linkP: string,
    imgP: string,
    fechaInicioP: number,
    fechaFinP: number
  ) {
    this.nombreP = nombreP;
    this.descripcionP = descripcionP;
    this.linkP = linkP;
    this.imgP = imgP;
    this.fechaInicioP = fechaInicioP;
    this.fechaFinP = fechaFinP;
  }
}
