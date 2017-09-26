package esercitazione;

public class OperazioniSuNumeri {
	
	public int sottrazione(int x, int y){
		int sottrazione;
		sottrazione = x-y;
		return sottrazione;
	}
	
	public double divisione(double x, double y){
		double divisione;
		divisione = x/y;
		return divisione;
	}
	
	public String comparazione(int x, int y){
		if(x>y){
			String esito = "x " + x + " è maggiore di y " + y;
			return esito;
		}else{
			String esito = "y " + y + " è maggiore di x " + x;
			return esito;
		}
	}

}
