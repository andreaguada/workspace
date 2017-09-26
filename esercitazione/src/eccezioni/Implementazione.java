package eccezioni;

import esercitazione.OperazioniSuNumeri;

public class Implementazione extends OperazioniSuNumeri {

	public static void main(String args[]) {

		double divisione;

		OperazioniSuNumeri operazioni = new OperazioniSuNumeri();
		
		try{
			divisione = operazioni.divisione(20, 0);
			System.out.println("Il risultato della divisione è: " + divisione);
		}
		catch(ArithmeticException a){
			System.out.println("La divisione per 0 non è possibile");
		}

	}

}
