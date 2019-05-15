import { Annonce } from './Annonce';
import { User } from './User';

export class Message {
	constructor(
		public messageId: number,
        public titre: string,
        public contenu: string,
        public date: Date,
        public annonceId: Annonce,
        public userId: User) {}
}