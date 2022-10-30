export class SoftSkill {
  id?: number;
  nombreSf: string;
  porcentajeSf: number;

  constructor(nombreSf: string, porcentajeSf: number) {
    this.nombreSf = nombreSf;
    this.porcentajeSf = porcentajeSf;
  }
}
