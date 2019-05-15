import { User } from './User';

export class Animal {
	constructor(
		public animalId: number,
        public nom: string,
        public age: number,
        public espece: string,
        public description: string,
        public user: User) {}
}