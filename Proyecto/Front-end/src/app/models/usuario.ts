export class Usuario {
    constructor(
        public id: number,
        public nombre: string,
        public apellidos: string,
        public contraseña: string,
        public email: string,
        public avatar: string,
        public rol: string,
        public mensajeBaneo: string,
        public estado: string
    ) { }
}