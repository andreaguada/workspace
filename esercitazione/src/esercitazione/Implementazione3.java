package esercitazione;

public class Implementazione3 {
	public static void main(String[] args) {

	OperazioniSuNumeri3 operazioni = new OperazioniSuNumeri3(10,2);
    
    int sottrazione = operazioni.sottrazione();
    int somma = operazioni.somma(); 
        
    System.out.println(somma);
    System.out.println(sottrazione);
    
    System.out.println(Math.sqrt(somma));
   

	}
}