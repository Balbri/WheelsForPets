import { Annonce } from './Annonce';
import { Message } from './Message';
import { Animal } from './Animal';

export class User {
	constructor(
		public userId: number,
        public nom: string,
        public prenom: string,
        public dateNaissance: Date,
        public password: string,
        public numRue: number,
        public rue: string,
        public codePostal: number,
        public ville: string,
        public vehicule: string,
        public username: string, 
        public enabled: boolean,
        public annonceList: Annonce[],
        public messageList: Message[],
        public animalList: Animal[]) {}
}

