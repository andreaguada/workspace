package astrazione;

public abstract class Programmatore {
	private String nome;
	private String cognome;
	private int anniEsperienza;
	
	public Programmatore(String nome, String cognome, int anniEsperienza){
		this.nome = nome;
		this.cognome = cognome;
		this.anniEsperienza = anniEsperienza;
	}
	
	public abstract void programma();
}
