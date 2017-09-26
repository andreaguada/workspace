package esercitazione;

public class Implementazione {
	
	public static void main(String args[]){
	Numeri numeri1 = new Numeri();
	Numeri numeri2 = new Numeri();
	
	numeri1.setNumeroX(2);
	numeri1.setNumeroY(3);
	numeri2.setNumeroX(5);
	numeri2.setNumeroY(6);
	
	System.out.println(numeri1.getNumeroX());
	System.out.println(numeri1.getNumeroY());
	System.out.println(numeri2.getNumeroX());
	System.out.println(numeri2.getNumeroY());
	}
}
