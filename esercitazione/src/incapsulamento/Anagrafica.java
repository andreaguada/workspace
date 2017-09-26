package incapsulamento;

public class Anagrafica {

	private String nome;
	private int dataDiNascita;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(int dataDiNascita) {
		if(dataDiNascita > 1990 && dataDiNascita < 2000){
			this.dataDiNascita = dataDiNascita;
		}
		else{
			System.out.println("errato");
		}
	}
}
