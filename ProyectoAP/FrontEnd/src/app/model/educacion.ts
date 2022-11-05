export class Educacion {
  id?: number;
  institucionEd: string;
  tituloEd: string;
  imgInstitucionEd: string;
  fechaInicioEd: number;
  fechaFinEd: number;

  // String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd
  constructor(
    institucionEd: string,
    tituloEd: string,
    imgInstitucionEd: string,
    fechaInicioEd: number,
    fechaFinEd: number
  ) {
    this.institucionEd = institucionEd;
    this.tituloEd = tituloEd;
    this.imgInstitucionEd = imgInstitucionEd;
    this.fechaInicioEd = fechaInicioEd;
    this.fechaFinEd = fechaFinEd;
  }
}
