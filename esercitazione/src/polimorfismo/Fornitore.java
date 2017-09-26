package polimorfismo;

public class Fornitore {
	private String nome;
	private String partitaIVA;
	private int telefono;
	private int fax;
	
	public Fornitore(String n, String p, int t, int f){
		nome = n;
		partitaIVA = p;
		telefono = t;
		fax = f;
	}
	
	public Fornitore(String n, String p, int f){
		nome = n;
		partitaIVA = p;
		fax = f;
	}

}
