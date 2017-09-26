package ereditarietà;

public class Dipendente extends Object{
	private String nome;
	private String cognome;
	private int oreLavorativeMensili;
	private int retribuzioneOraria;
	
	public int getOreLavorativeMensili() {
		return oreLavorativeMensili;
	}
	public int getRetribuzioneOraria() {
		return retribuzioneOraria;
	}
	public int stipendio(){
		return oreLavorativeMensili + retribuzioneOraria;
	}
	
	public Dipendente(String n, String c, int o, int r){
		nome = n;
		cognome = c;
		oreLavorativeMensili = o;
		retribuzioneOraria = r;
	}
}
