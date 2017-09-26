package incapsulamento;

public class ImplementazioneAnagrafica {
	public static void main(String[] args) {

		Anagrafica anagrafica = new Anagrafica();
		anagrafica.setNome("Andrea");
		anagrafica.setDataDiNascita(1993);
		
		System.out.println(anagrafica.getNome());
		System.out.println(anagrafica.getDataDiNascita());
	}
}
