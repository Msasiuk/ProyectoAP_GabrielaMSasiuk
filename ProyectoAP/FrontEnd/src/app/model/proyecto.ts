export class Proyecto {
  id?: number;
  nombreP: string;
  descripcionP: string;
  imgP: string;
  linkP: string;
  fechaP: number;

  constructor(
    nombreP: string,
    descripcionP: string,
    imgP: string,
    linkP: string,
    fechaP: number
  ) {
    this.nombreP = nombreP;
    this.descripcionP = descripcionP;
    this.imgP = imgP;
    this.linkP = linkP;
    this.fechaP = fechaP;
  }
}
