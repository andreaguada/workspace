package esercitazione;

public class Numeri {
	
	private int numeroX;
	private int numeroY;
	
	public int getNumeroX() {
		return numeroX;
	}
	public void setNumeroX(int numeroX) {
		this.numeroX = numeroX;
	}
	public int getNumeroY() {
		return numeroY;
	}
	public void setNumeroY(int numeroY) {
		this.numeroY = numeroY;
	}
	
	public int sottrazione(){
		if(numeroX>numeroY)
			return numeroX-numeroY;
		else
			return numeroY-numeroX;
	}
}
