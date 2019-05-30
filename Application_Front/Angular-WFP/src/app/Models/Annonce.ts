import { User } from './User';
import { Message} from './Message'

export class Annonce {
	constructor(
		public annonceId: number,
		public dateRedaction: Date,
		public titre: string,
		public description: string,
		public villeDepart: string,
		public cpDepart: number,
		public dateDepart: Date,
		public villeArrivee: string,
		public cpArrivee: number,
		public dateArrivee: number,
		public prix: number,
		public validee: boolean,
		public dateModif: Date,
		public messageList: Message[],
        public user: User,
        public acheteur: User) {}
}