import { Exercice } from "./exerciceClass.model";


export interface Program {
	id?: number;
	nom: string;
	nombreJours: number;
	exercices: any[];
}