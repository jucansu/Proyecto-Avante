import { Usuario } from "./usuario";

export class Publicacion {
    constructor(
        public id: number,
        public titulo: string,
        public descripcion: string,
        public etiqueta: string,
        public fecha: Date,
        public valoracion: number,
        public id_usuario : number
    ) { }
}