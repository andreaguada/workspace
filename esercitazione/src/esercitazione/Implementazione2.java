package esercitazione;

public class Implementazione2 {

	public static void main(String[] args) {
		OperazioniSuNumeri operazioni = new OperazioniSuNumeri();
		
		int sottrazione = operazioni.sottrazione(4, 8);
		String esitoComparazione = new String();
		esitoComparazione = operazioni.comparazione(10, 18);
		
		System.out.println(sottrazione);
		System.out.println(esitoComparazione);
	}

}
