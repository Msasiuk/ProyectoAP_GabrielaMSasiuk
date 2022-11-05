export class Experiencia {
  id?: number;
  empresaEx: string;
  tituloEx: string;
  descripcionEx: string;
  imgEmpresaEx: string;
  fechaInicioEx: number;
  fechaFinEx: number;

  // String empresaEx, String tituloEx, String descripcionEx, String imgEmpresaEx, int fechaInicioEx, int fechaFinEx
  constructor(
    empresaEx: string,
    tituloEx: string,
    descripcionEx: string,
    imgEmpresaEx: string,
    fechaInicioEx: number,
    fechaFinEx: number
  ) {
    this.empresaEx = empresaEx;
    this.tituloEx = tituloEx;
    this.descripcionEx = descripcionEx;
    this.imgEmpresaEx = imgEmpresaEx;
    this.fechaInicioEx = fechaInicioEx;
    this.fechaFinEx = fechaFinEx;
  }
}
